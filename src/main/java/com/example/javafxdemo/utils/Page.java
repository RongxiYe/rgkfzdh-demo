package com.example.javafxdemo.utils;

/**
 * Enumerate pages and return parameters.
 *
 * @author RongxiYe
 * @version 1.0
 */
public enum Page {
    /**
     * main page
     */
    MAIN{
        public Page back(){
            return null;
        }
    },
    /**
     * first page
     */
    FIRSTPAGE{
        public Page back(){return null;}
    },
    /**
     * login page using booking number
     */
    BOOKNUMLOGIN{
        public Page back(){
            return null;
        }
    },
    /**
     * login page using id information
     */
    IDINFOLOGIN{
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    /**
     * login page using id card
     */
    IDCARDLOGIN{
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    /**
     * first view page
     */
    FIRSTVIEW{
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    /**
     * select seat page
     */
    SEATSELECT{
        public Page back(){
            return FIRSTVIEW;
        }
    },
    /**
     * meal select page
     */
    MEALSELECT{
        public Page back(){
            return SEATSELECT;
        }
    },
    /**
     * confirmation of seats and meal plan
     */
    SMCONFIRM{
        public Page back(){
            return MEALSELECT;
        }
    },
    /**
     * confirmation and printing page
     */
    CHECKINVIEW{
        public Page back(){
            return null;
        }
    },
    /**
     * extra payment page
     */
    CREDITINFO{
        public Page back(){
            return SMCONFIRM;
        }
    },
    /**
     * last page
     */
    LASTPAGE{
        public Page back(){
            return null;
        }
    },
    /**
     * help information page
     */
    HELPINFO{
        public Page back() { return null; }
    };

    /**
     * return to thr former page
     * @return the page of the former page
     */
    public abstract Page back();

}
