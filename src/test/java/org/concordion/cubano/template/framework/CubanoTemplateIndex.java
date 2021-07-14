package org.concordion.cubano.template.framework;

import org.concordion.api.ConcordionResources;
import org.concordion.api.extension.Extension;
import org.concordion.api.extension.Extensions;
import org.concordion.cubano.config.Config;
import org.concordion.cubano.driver.concordion.EnvironmentExtension;
import org.concordion.cubano.framework.ConcordionBase;
import org.concordion.cubano.template.AppConfig;
import org.concordion.ext.TimestampFormatterExtension;
import org.concordion.ext.runtotals.RunTotalsExtension;

/**
 * A base class for extension by fixtures which relate to "index" specifications containing no assertions.
 *
 * @see CubanoTemplateFixture for fixtures that don't invoke a browser
 * @see CubanoTemplateFixture for fixtures that invoke a browser
 */
@ConcordionResources("/customConcordion.css")
@Extensions({ TimestampFormatterExtension.class, RunTotalsExtension.class })
public abstract class CubanoTemplateIndex extends ConcordionBase {
    @Extension
    private final EnvironmentExtension footer = new EnvironmentExtension()
            .withEnvironment(Config.getInstance().getEnvironment().toUpperCase())
            .withURL(AppConfig.getInstance().getWebUrl());
}
