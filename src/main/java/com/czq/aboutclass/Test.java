package com.czq.aboutclass;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/2
 */
public class Test {

    public static void main(String[] args) throws Exception{

        System.out.println(isAllFieldNull(new Page(1L,2L,null)));

        Integer a = 129;
        Integer b = 129;
        Integer c = 126;
        Integer d = 126;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a == c);

        Page p = new Page();
       // p.setId(1L);
        Long start;
        System.out.println(start = System.currentTimeMillis());
        jude(p);
        System.out.printf("===== %d",System.currentTimeMillis() - start);
    }

    public static boolean isAllFieldNull(Object o)throws Exception{
        if (o == null){
            return true;
        }
        Class<?> c = o.getClass();
        Field[] f = c.getDeclaredFields();
        boolean flag = true;
        for (Field field : f){
            field.setAccessible(true);
            Object of = field.get(o);
            if (of != null){
                 flag = false;
            }
        }
        return flag;
    }


    public static void jude(Object object) throws Exception {
        if (object == null){
            throw new Exception("参数为空");
        }
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            NotNullProperty no = f.getAnnotation(NotNullProperty.class);
           // System.out.println(f.get(object));
            if (no != null && f.get(object) == null) {
                throw new Exception(no.value() + "为空");
//                System.out.println(no.value() + "为空");
            }
        }
    }

}
class Page{

    /**
     * 主键id
     */
    @NotNullProperty("主键id")
    private Long id = 11L;

    /**
     * 商户id
     */
    @NotNullProperty("商户id")
    private Long pid;

    /**
     * 门店id
     */
    @NotNullProperty("门店id")
    private Long storeId;

    @NotNullProperty("name")
    private Long name;

    /**
     * 主键id
     */
    @NotNullProperty("主键id2")
    private Long id2;

    /**
     * 商户id
     */
    @NotNullProperty(" 商户id")
    private Long pid2;

    /**
     * 门店id
     */
    @NotNullProperty("1")
    private Long storeId2;

    /**
     * 页面状态 0未发布，1已发布，2定时发布
     */
    @NotNullProperty("2")
    private Integer releaseStatus;

    /**
     * 页面标签id
     */
    @NotNullProperty("3")
    private Integer pageTagId;

    /**
     * 是否首页，0非首页，1是首页
     */
    @NotNullProperty("4")
    private Integer isDefault;

    /**
     * 页面标题(搜索关键词)
     */
    @NotNullProperty("5")
    private String title;

    /**
     * 需要过滤的模板Id
     */
    @NotNullProperty("6")
    private Integer templateId;

    /**
     * 屏蔽的模板Id
     */
    @NotNullProperty("7")
    private List<Integer> maskTemplateIds;

    /**
     * 区域Idlist
     */
    @NotNullProperty("8fff")
    private List<Long> departmentIdList;

    /**
     * 是否删除 1删除 0未删除
     */
    @NotNullProperty("f9")
    private Integer isDeleted;


    /**
     * 屏蔽的模板Id
     */
    @NotNullProperty("9v")
    private List<Integer> maskTemplateIds1;

    /**
     * 区域Idlist
     */
    @NotNullProperty("49")
    private List<Long> departmentIdLis;

    /**
     * 是否删除 1删除 0未删除
     */  @NotNullProperty("90")
    private Integer isDeleted1;

    private Long id1;
    private Long pid11;
    private Long storeId111;
    private Long siteId;
    private String siteName;
    private String siteManagerUserName;
    private String siteManagerZone;
    private String managerName;
    private Long managerWid;
    private String siteTel;
    private String provinceCode;
    private String cityCode;
    private String countyCode;
    private String areaCode;
    private String provinceName;
    private String cityName;
    private String countyName;
    private String areaName;
    private String address;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Integer isUse;
    private String bussinessTime;
    private List<Long> businessTimeVoList;
    private Long distance;
    private Integer isServer;
    private Integer bizType;


    private Integer orderStatus;
    private BigDecimal paymentAmount;
    private Integer paymentType;
    private List<INACTIVE> itemIdList;
    private Integer deliveryType;
    private Integer bizType1;
    private Integer goodsPromotionType;
    private Integer referOrderType;
    /**@description 订单号*/
    private Long orderNo;
    /**@description 订单状态*/
    private Integer orderStsatus;
    /**@description 订单状态名称*/
    private String orderStatusName;
    /**@description 下单时间*/
    private Date createTime;
    /**@description 商品总金额*/
    private BigDecimal goodsAmount;
    /**@description 订单总金额 = 商品总金额+运费*/
    private BigDecimal totalAmount;
    /**@description 订单总积分*/
    private Integer totalPoint;
    /**@description 订单实付金额*/
    private BigDecimal paymentAmosunt;
    /**@description 买家备注*/
    private String buyerRemark;
    /**@description 取消类型*/
    private Integer cancelType;
    /**@description 取消原因id*/
    private Integer cancelReasonId;
    /**@description 具体取消原因*/
    private String specificCancelReason;
    /**@description 自动取消时间*/
    private Long autoCancelTime;
    /**@description 取消时间*/
    private Date cancelTime;
    /**@description 完结时间，订单完成时表示完成时间，取消时表示取消时间*/
    private Date finishTime;
    /**@description 业务信息*/

    /**配送方式*/
    private Integer deliveryMethod;
    private Integer deliverysType;
    /**取消详细原因*/
    private String cancelDetail;
    /**是否是周期购订单*/
    private Boolean isCycleOrder = Boolean.FALSE;
    /**周期购信息*/
    /**
     * 商品销售类型
     */
    private Integer goodsPrsomotionType;
    /**
     * 是否显示商品评价
     */
    private Boolean showComment = Boolean.FALSE;

    /**
     * 是否是积分商城订单
     */
    private Boolean isPointOrder = Boolean.FALSE;

    /**
     * 营销类型。1普通；2周期购；3积分商城
     */
    private Integer promotionType;

    /**
     * 最近一期包裹的状态
     */
    private Integer packageStatus;

    /**
     * 过期处理方式 1.过期后，订单将自动完成，不退款 2.过期后，订单将自动维权，自动向买家退款
     */
    private Integer expiryDateDealType;
    /**
     * 导购信息

    /**
     * 是否同步微信购物车
     */
    private Boolean syncShoppingList;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 【业务来源类型】1、正常线上订单，2，线下导购开单, 3,收银台订单
     */
    private Integer bizSourceType;

    /**
     * 预售信息

    /**
     *   可以跳转商品信息 0不可以跳
     */
    private Integer canQueryGoodsDetail;

    private Boolean isShowGuarantee = Boolean.TRUE;

    private Boolean canCopy = Boolean.TRUE;

    private Integer type;
    private String key;
    private String naddme;
    private Object value;
    private String showValue;
    private Byte required;
    private Byte canModify;
    private Byte enabled;
    private Integer seq;
    private String placeholder;
    private String optionType;
    private List<Long> optionList;
    private List<String> optionUpdateList;
    private String validate;
    private Integer maxLen;




    public Page() {
    }
    Page(Long id, Long pid, Long storeId) {
        this.id = id;
        this.pid = pid;
        this.storeId = storeId;
    }
}

