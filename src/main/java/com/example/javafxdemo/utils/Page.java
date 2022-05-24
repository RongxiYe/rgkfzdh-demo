package com.example.javafxdemo.utils;

/**
 * Enumerate pages and return parameters.
 *
 * @author RongxiYe
 * @version 1.0
 */
public enum Page {
    MAIN{
        public Page back(){
            return null;
        }
    },
    FIRSTPAGE{
        public Page back(){return null;}
    },
    BOOKNUMLOGIN{
        public Page back(){
            return null;
        }
    },
    IDINFOLOGIN{
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    IDCARDLOGIN{
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    FIRSTVIEW{
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    SEATSELECT{
        public Page back(){
            return FIRSTVIEW;
        }
    },
    MEALSELECT{
        public Page back(){
            return SEATSELECT;
        }
    },
    SMCONFIRM{
        public Page back(){
            return MEALSELECT;
        }
    },
    CHECKINVIEW{
        public Page back(){
            return null;
        }
    },
    CREDITINFO{
        public Page back(){
            return SMCONFIRM;
        }
    },
    LASTPAGE{
        public Page back(){
            return null;
        }
    },
    HELPINFO{
        public Page back() { return null; }
    };

    public abstract Page back();

}
