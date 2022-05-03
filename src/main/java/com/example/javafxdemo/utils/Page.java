package com.example.javafxdemo.utils;

public enum Page {
    MAIN{
        public Page next(){
            return null;
        }
        public Page back(){
            return null;
        }
    },
    FIRSTPAGE{
        public Page next(){return null;}
        public Page back(){return null;}
    },
    BOOKNUMLOGIN{
        public Page next(){
            return null;
        }
        public Page back(){
            return null;
        }
    },
    IDINFOLOGIN{
        public Page next(){
            return null;
        }
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    IDCARDLOGIN{
        public Page next(){
            return null;
        }
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    FIRSTVIEW{
        public Page next(){
            return SEATSELECT;
        }
        public Page back(){
            return BOOKNUMLOGIN;
        }
    },
    SEATSELECT{
        public Page next(){
            return MEALSELECT;
        }
        public Page back(){
            return FIRSTVIEW;
        }
    },
    MEALSELECT{
        public Page next(){
            return SMCONFIRM;
        }
        public Page back(){
            return SEATSELECT;
        }
    },
    SMCONFIRM{
        public Page next(){
            return null;
        }
        public Page back(){
            return MEALSELECT;
        }
    },
    EXTRAPAY{
        public Page next(){
            return null;
        }
        public Page back(){
            return SMCONFIRM;
        }
    },
    CHECKINVIEW{
        public Page next(){
            return null;
        }
        public Page back(){
            return null;
        }
    },
    CREDITINFO{
        public Page next(){
            return null;
        }
        public Page back(){
            return SMCONFIRM;
        }
    },
    PRINT{
        public Page next(){
            return null;
        }
        public Page back(){
            return null;
        }
    },
    LASTPAGE{
        public Page next(){
            return null;
        }
        public Page back(){
            return null;
        }
    },
    HELPINFO{
        public Page next(){
            return null;
        }
        public Page back(){
            return null;
        }
    };
    public abstract Page next();
    public abstract Page back();

}
