package com.example.javafxdemo.controller.FirstPage;

import com.example.javafxdemo.controller.Controller;
import com.example.javafxdemo.controller.Handler;
import com.example.javafxdemo.controller.MainController;
import com.example.javafxdemo.utils.Page;

public class FirstPageController implements Controller {

    @Override
    public void init() {

    }

    public void onClickButton(){
        MainController main = (MainController) Handler.getController(Page.MAIN);
        main.loadRoot(Page.BOOKNUMLOGIN);
    }


}
