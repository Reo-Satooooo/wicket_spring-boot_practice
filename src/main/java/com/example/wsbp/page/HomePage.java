package com.example.wsbp.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.springframework.boot.Banner;
import org.wicketstuff.annotation.mount.MountPath;
import com.example.wsbp.service.ISampleService;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

@WicketHomePage
@MountPath("Home")
public class HomePage extends WebPage {

    @SpringBean
    private ISampleService service;

    public HomePage() {
        var youModel = Model.of("Wicket-Spring-Boot");
        var youLabel = new Label("you", youModel);
        add(youLabel);

        var gakusekiModel = Model.of("B2191040");
        var gakusekiLabel = new Label("gakuseki",gakusekiModel);
        add(gakusekiLabel);

        var nameModel = Model.of("佐藤玲央");
        var nameLabel = new Label("name",nameModel);
        add(nameLabel);

        var timeModel = Model.of(service.makeCurrentHMS());
        var timeLabel = new Label("time", timeModel);
        add(timeLabel);

        var randomIntModel = Model.of(service.makeRandInt());
        var randomIntLabel = new Label("randomInt",randomIntModel);
        add(randomIntLabel);

        var toUserMakerLink = new BookmarkablePageLink<>("toUserMaker", UserMakerPage.class);
        add(toUserMakerLink);

        var toUserDeleteLink = new BookmarkablePageLink<>("toUserDelete", UserDeletePage.class);
        add(toUserDeleteLink);
    }

}