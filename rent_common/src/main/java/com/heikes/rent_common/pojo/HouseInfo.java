package com.heikes.rent_common.pojo;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * <p>
 * 房源信息表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class HouseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 楼盘名称
     */
    private String estateName;

    /**
     * 户型
     */
    private Integer houseType;

    /**
     * 面积(㎡)
     */
    private Integer area;

    /**
     * 房租 (元/月)
     */
    private Integer rent;

    /**
     * 地段
     */
    private String lot;

    /**
     * 地址
     */
    private String address;

    /**
     * 房屋具体情况
     */
    private String label;

    /**
     * 房屋租住状态,0代表未出租,1代表已经出租	
     */
    private Integer status;

    /**
     * 关联房东表
     */
    private Integer landlordId;

    /**
     * 纬度
     */
    private BigDecimal lat;

    /**
     * 经度
     */
    private BigDecimal lng;

    /**
     * 房屋描述	
     */
    private String desc;

    /**
     * 0代表优惠帮扶,1代表不帮扶	
     */
    private Integer offStatus;

    /**
     * 0代表优惠帮扶,1代表不帮扶
     */
    private Integer checkStatus;

    /**
     * 退订政策，默认为1（灵活的取消政策）
     */
    private Integer cancelPolicy;

    /**
     *
     * 房东名字
     */
    private String landlordName;

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }
    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }
    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }
    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Integer getOffStatus() {
        return offStatus;
    }

    public void setOffStatus(Integer offStatus) {
        this.offStatus = offStatus;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getCancelPolicy() {
        return cancelPolicy;
    }

    public void setCancelPolicy(Integer cancelPolicy) {
        this.cancelPolicy = cancelPolicy;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", estateName='" + estateName + '\'' +
                ", houseType=" + houseType +
                ", area=" + area +
                ", rent=" + rent +
                ", lot='" + lot + '\'' +
                ", address='" + address + '\'' +
                ", label='" + label + '\'' +
                ", status=" + status +
                ", landlordId=" + landlordId +
                ", lat=" + lat +
                ", lng=" + lng +
                ", desc='" + desc + '\'' +
                ", offStatus=" + offStatus +
                ", checkStatus=" + checkStatus +
                ", cancelPolicy=" + cancelPolicy +
                ", landlordName='" + landlordName + '\'' +
                '}';
    }
}
