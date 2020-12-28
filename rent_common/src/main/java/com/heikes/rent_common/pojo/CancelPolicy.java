package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class CancelPolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 取消策略id
     */
    private Long policyId;

    /**
     * 取消策略名称
     */
    private String policyName;

    /**
     * 取消策略内容
     */
    private String policyContent;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
    public String getPolicyContent() {
        return policyContent;
    }

    public void setPolicyContent(String policyContent) {
        this.policyContent = policyContent;
    }

    @Override
    public String toString() {
        return "CancelPolicy{" +
            "policyId=" + policyId +
            ", policyName=" + policyName +
            ", policyContent=" + policyContent +
        "}";
    }
}
