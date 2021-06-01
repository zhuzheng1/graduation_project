package com.cx.domain;

public class ShareIdVo {
    private String shareBookId;
    private String shareTime;
    private String backTime;
    private String share_bookName;

    public String getShare_bookName() {
        return share_bookName;
    }

    public void setShare_bookName(String share_bookName) {
        this.share_bookName = share_bookName;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public String getShareBookId() {
        return shareBookId;
    }

    public void setShareBookId(String shareBookId) {
        this.shareBookId = shareBookId;
    }

    public String getShareTime() {
        return shareTime;
    }

    public void setShareTime(String shareTime) {
        this.shareTime = shareTime;
    }
}
