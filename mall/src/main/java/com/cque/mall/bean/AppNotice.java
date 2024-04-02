package com.cque.mall.bean;

import lombok.Data;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:16:05:26
 */
@Data
public class AppNotice {
    Long notice_id;
    public Long getNotice_id() {
        return this.notice_id;
    }
    public void setNotice_id(Long notice_id) {
        this.notice_id = notice_id;
    }
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof AppNotice))
            return false;
        AppNotice other = (AppNotice) o;
        if (!other.canEqual(this))
            return false;
        Object this$notice_id = getNotice_id();
        Object other$notice_id = other.getNotice_id();
        return this$notice_id == null ? other$notice_id == null : this$notice_id.equals(other$notice_id);
    }

    protected boolean canEqual(Object other) {
        return other instanceof AppNotice;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $notice_id = getNotice_id();
        result = result * 59 + ($notice_id == null ? 43 : $notice_id.hashCode());
        return result;
    }

    public String toString() {
        return "AppNotice(notice_id=" + getNotice_id() + ")";
    }

    public AppNotice(Long notice_id) {
        this.notice_id = notice_id;
    }
}
