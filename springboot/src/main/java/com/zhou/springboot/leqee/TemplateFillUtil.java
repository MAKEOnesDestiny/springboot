package com.zhou.springboot.leqee;

import java.util.HashMap;
import java.util.Map;

public class TemplateFillUtil {

    public static void main(String[] args) {
        HashMap<String, Object> params = new HashMap<>();
        //
        params.put("platformId", 1);
        params.put("begin", 1);
        params.put("count", 1);
        //
        fill("select id,platform_id as platformId,platform_name as platformName,manage_mode as manageMode,platform_supplier as platformSupplier,\n"
                     + "platform_goods_barcode as platformGoodsBarcode,platform_product_id as platformProductId,platform_goods_id as platformGoodsId,platform_goods_name as platformGoodName,\n"
                     + "oms_barcode as omsBarcode,oms_business_code as omsBusinessCode,oms_goods_name as omsGoodsName,distribute_type as distributeType,update_time as updateTime,operator\n"
                     + "from bi_strategic.strategic_goods_mapping_maintain_new\n"
                     + "where platform_id in(#[#platformId]) \n"
                     + "and if(#{partyId}='' or #{partyId} is null,true,party_id=#[#partyId])\n"
                     + "and if(#{platformShopName}='' or #{platformShopName} is null,true,platform_shop_name=#{platformShopName})\n"
                     + "and if(#{manageMode}='' or #{manageMode} is null,true,manage_mode=#{manageMode})\n"
                     + "and if(#{distributeType}='' or #{distributeType} is null,true,distribute_type=#{distributeType})\n"
                     + "and if(#{platformSupplier}='' or #{platformSupplier} is null,true,platform_supplier=#{platformSupplier})\n"
                     + "and if(#{platformGoodsIds}='' or #{platformGoodsIds} is null,TRUE,find_in_set(platform_goods_id,#{platformGoodsIds})) \n"
                     + "and if(#{platformGoodsBarcode}='' or #{platformGoodsBarcode} is null,TRUE,platform_goods_id=#{platformGoodsBarcode}) \n"
                     + "and if(#{omsBusinessCode}='' or #{omsBusinessCode} is null,TRUE,oms_business_code=#{omsBusinessCode}) \n"
                     + "and if(#{omsGoodsName}='' or #{omsGoodsName} is null,TRUE,oms_goods_name=#{omsGoodsName}) \n"
                     + "and if(#{shield}='0',shield='屏蔽',shield='未屏蔽')\n"
                     + "and if(#{isMapping}='0',TRUE,if(#{isMapping}='1',oms_business_code is not null,oms_business_code is null))\n"
                     + "order by update_time desc\n"
                     + "limit #[#begin],#[#count];", params);
    }

    public static String fill(String template, Map<String, Object> params) {
        for (Map.Entry<String, Object> e : params.entrySet()) {
            String key = e.getKey();
//            template = template.replaceAll(new String("#{" + key + "}"), "'" + e.getValue().toString() + "'");
            template = template.replaceAll(new String("#[#" + key + "]"), e.getValue().toString());
        }
        System.out.println(template);
        return template;
    }

}
