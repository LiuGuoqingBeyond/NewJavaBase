package com.example.administrator.newjavabase.data.login.respons;

import android.text.TextUtils;

/**
 * User: LiuGuoqing
 * Data: 2018/9/17 0017.
 */

public class LoginRespInfo {

    /**
     * returnCode : 00
     * returnMsg : 登录成功
     * data : {"obtainSalesSlip4Trade":0,"bizMsg":"登录成功","bizCode":"00","yesterdayTransAmt":"0","todayTransAmt":"17545158.18","obtainSalesSlip4Remit":0,"yesterdayShareProfit":"0","accumulatedShareProfit":"0"}
     */

    private String returnCode;
    private String returnMsg;
    private DataBean data;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * obtainSalesSlip4Trade : 0
         * bizMsg : 登录成功
         * bizCode : 00
         * yesterdayTransAmt : 0
         * todayTransAmt : 17545158.18
         * obtainSalesSlip4Remit : 0
         * yesterdayShareProfit : 0
         * accumulatedShareProfit : 0
         */

        private int obtainSalesSlip4Trade;
        private String bizMsg;
        private String bizCode;
        private String yesterdayTransAmt;
        private String todayTransAmt;
        private int obtainSalesSlip4Remit;
        private String yesterdayShareProfit;
        private String accumulatedShareProfit;
        private String userName;
        private String oneClassAgent;

        public String getOneClassAgent() {
            return oneClassAgent;
        }

        public void setOneClassAgent(String oneClassAgent) {
            this.oneClassAgent = oneClassAgent;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getObtainSalesSlip4Trade() {
            return obtainSalesSlip4Trade;
        }

        public void setObtainSalesSlip4Trade(int obtainSalesSlip4Trade) {
            this.obtainSalesSlip4Trade = obtainSalesSlip4Trade;
        }

        public String getBizMsg() {
            return bizMsg;
        }

        public void setBizMsg(String bizMsg) {
            this.bizMsg = bizMsg;
        }

        public String getBizCode() {
            return bizCode;
        }

        public void setBizCode(String bizCode) {
            this.bizCode = bizCode;
        }

        public String getYesterdayTransAmt() {
            return yesterdayTransAmt;
        }

        public void setYesterdayTransAmt(String yesterdayTransAmt) {
            this.yesterdayTransAmt = yesterdayTransAmt;
        }

        public String getTodayTransAmt() {
            return todayTransAmt;
        }

        public void setTodayTransAmt(String todayTransAmt) {
            this.todayTransAmt = todayTransAmt;
        }

        public int getObtainSalesSlip4Remit() {
            return obtainSalesSlip4Remit;
        }

        public void setObtainSalesSlip4Remit(int obtainSalesSlip4Remit) {
            this.obtainSalesSlip4Remit = obtainSalesSlip4Remit;
        }

        public String getYesterdayShareProfit() {
            return yesterdayShareProfit;
        }

        public void setYesterdayShareProfit(String yesterdayShareProfit) {
            this.yesterdayShareProfit = yesterdayShareProfit;
        }

        public String getAccumulatedShareProfit() {
            return accumulatedShareProfit;
        }

        public void setAccumulatedShareProfit(String accumulatedShareProfit) {
            this.accumulatedShareProfit = accumulatedShareProfit;
        }
    }

    public boolean isOk() {
        return TextUtils.equals("00", returnCode);
    }
}
