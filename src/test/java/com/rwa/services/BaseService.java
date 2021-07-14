package com.rwa.services;


import org.concordion.api.FullOGNL;
import org.concordion.cubano.driver.http.HttpEasy;
import org.concordion.cubano.template.AppConfig;
import org.concordion.cubano.template.driver.logger.TestLoggerLogWriter;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;
import org.concordion.ext.StoryboardMarkerFactory;
import org.concordion.ext.storyboard.CardResult;
import org.concordion.ext.storyboard.StockCardImage;
import org.concordion.slf4j.ext.MediaType;
import org.concordion.slf4j.ext.ReportLogger;
import org.concordion.slf4j.ext.ReportLoggerFactory;

@FullOGNL
public class BaseService extends CubanoTemplateFixture {
    protected ReportLogger log = ReportLoggerFactory.getReportLogger(BankAccountService.class);
    protected HttpEasy easy = HttpEasy.request().baseUrl(AppConfig.getInstance().getApiUrl());
    protected TestLoggerLogWriter testLoggerLogWriter = new TestLoggerLogWriter();

    protected void addNotification(String name, String data) {
        log
                .with()
                .message(name)
                .attachment(data, name + ".json", MediaType.PLAIN_TEXT)
                .marker(StoryboardMarkerFactory.addCard(
                        name,
                        StockCardImage.JSON, CardResult.SUCCESS))
                .debug();
    }
}
