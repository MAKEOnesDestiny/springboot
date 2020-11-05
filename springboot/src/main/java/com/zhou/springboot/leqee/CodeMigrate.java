package com.zhou.springboot.leqee;

public class CodeMigrate {

    public static void main(String[] args) {
        String s = "    <select id=\"selectStrategicDataMngApplyMapIndexByTableIdForEB\" parameterType=\"java.util.Map\"\n"
                + "            resultType=\"strategic.facade.entities.StrategicDataMngApplyMapIndex\">\n"
                + "        select\n"
                + "        i.id,\n"
                + "        i.origin_table,\n"
                + "        i.field_name,\n"
                + "        i.index_name,\n"
                + "        i.type,\n"
                + "        i.source,\n"
                + "        i.meaning,\n"
                + "        i.db_name\n"
                + "        from bi_strategic.strategic_data_mng_apply_map_index i\n"
                + "\n"
                + "        where i.table_id = #{tableId}\n"
                + "        <if test=\"typeCode != null and typeCode != '' \">\n"
                + "            and i.type=#{typeCode}\n"
                + "        </if>\n"
                + "        <if test=\"originTable != null and originTable != '' \">\n"
                + "            and i.origin_table=#{originTable}\n"
                + "        </if>\n"
                + "        <if test=\"keyword != null and keyword != '' \">\n"
                + "            and\n"
                + "            (i.index_name like CONCAT('%',#{keyword},'%') or\n"
                + "            i.source like CONCAT('%',#{keyword},'%') or\n"
                + "            i.meaning like CONCAT('%',#{keyword},'%')\n"
                + "            )\n"
                + "        </if>\n"
                + "    </select>";
        s = s.replaceAll("bi_strategic\\.", "bi\\.");
        s = s.replaceAll("strategic_data_mng_apply_map_table", "data_map_mng_apply_map_table");
        s = s.replaceAll("strategic_data_mng_apply_map_file", "data_map_mng_apply_map_file");
        s = s.replaceAll("strategic_data_mng_apply_map_space", "data_map_mng_apply_map_space");
        s = s.replaceAll("strategic_data_mng_apply_map_product", "data_map_mng_apply_map_product");
        s = s.replaceAll("strategic_data_mng_apply_map_index", "data_map_mng_apply_map_index");

        System.out.println(s);
    }

}
