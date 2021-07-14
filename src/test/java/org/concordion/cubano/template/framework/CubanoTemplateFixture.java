package org.concordion.cubano.template.framework;

import java.io.Closeable;

import org.concordion.api.ConcordionResources;
import org.concordion.api.FailFast;
import org.concordion.api.extension.Extension;
import org.concordion.api.extension.Extensions;
import org.concordion.cubano.config.Config;
import org.concordion.cubano.driver.concordion.EnvironmentExtension;
import org.concordion.cubano.driver.concordion.ExceptionHtmlCaptureExtension;
import org.concordion.cubano.framework.ConcordionBrowserFixture;
import org.concordion.cubano.framework.resource.CloseListener;
import org.concordion.cubano.framework.resource.ResourceScope;
import org.concordion.cubano.template.AppConfig;
import org.concordion.cubano.template.driver.httpeasy.HttpEasyConfigurator;
import org.concordion.ext.StoryboardMarkerFactory;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.ext.runtotals.RunTotalsExtension;
import org.concordion.ext.statusinfo.StatusInfoExtension;
import org.concordion.ext.storyboard.CardResult;
import org.concordion.ext.storyboard.StockCardImage;
import org.concordion.slf4j.ext.MediaType;
import org.concordion.slf4j.ext.ReportLogger;
import org.concordion.slf4j.ext.ReportLoggerFactory;

/**
 * A base class for extension by fixtures that invoke a browser, and may also use HttpEasy.
 *
 * Customises the test specification and provides some helper methods so the tests can access the storyboard, browser, etc.
 *
 * @see CubanoTemplateIndex for fixtures that don't contain assertions
 * @see CubanoTemplateFixture for fixtures that don't invoke a browser
 */
@ConcordionResources("/customConcordion.css")
@Extensions({ TimestampFormatterExtension.class, RunTotalsExtension.class, StatusInfoExtension.class })
@FailFast
public abstract class CubanoTemplateFixture extends ConcordionBrowserFixture {
    @Extension
    private final EnvironmentExtension footer = new EnvironmentExtension()
            .withEnvironment(Config.getInstance().getEnvironment().toUpperCase())
            .withURL(AppConfig.getInstance().getWebUrl());

    protected final ReportLogger reportLogger = ReportLoggerFactory.getReportLogger(this.getClass().getName());

    @Extension
    private final ExceptionHtmlCaptureExtension htmlCapture = new ExceptionHtmlCaptureExtension(getStoryboard(), getBrowser());

    static {
        HttpEasyConfigurator.applyDefaultSettings();
    }

    /** Override the default fixture logger. **/
    public CubanoTemplateFixture() {
        super.withFixtureListener(new CubanoTemplateFixtureLogger());
    }

    @Override
    public void registerCloseableResource(Closeable resource, ResourceScope scope) {
        CloseListener listener = new CloseListener() {

            @Override
            public void beforeClosing(Closeable resource) {
                // Prevent any further cards being added to the storyboard
                getStoryboard().setAcceptCards(false);
                reportLogger.step("Clean up data for " + resource);
            }

            @Override
            public void afterClosing(Closeable resource) {
                getStoryboard().setAcceptCards(true);
            }
        };
        super.registerCloseableResource(resource, scope, listener);
    }
}
