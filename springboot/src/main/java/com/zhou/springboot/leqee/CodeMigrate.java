package com.zhou.springboot.leqee;

public class CodeMigrate {

    public static void main(String[] args) {
        String s = "    <select id=\"selectDuplicateFileCountByFileId\" resultType=\"java.lang.Integer\">\n"
                + "        select count(*)\n"
                + "        from bi_strategic.strategic_data_mng_apply_map_file f\n"
                + "        inner join bi_strategic.strategic_data_mng_apply_map_space s on f.space_id=s.id\n"
                + "        where f.id!=#{id} and f.file=#{name} and s.product_id=(select s.product_Id\n"
                + "        from bi_strategic.strategic_data_mng_apply_map_file f\n"
                + "        inner join bi_strategic.strategic_data_mng_apply_map_space s on f.space_id=s.id\n"
                + "        where f.id=#{id}\n"
                + "        )\n"
                + "        group by f.file,s.product_id\n"
                + "        order by null\n"
                + "    </select>\n"
                + "\n"
                + "    <select id=\"selectDuplicateFileCountBySpaceId\" resultType=\"java.lang.Integer\">\n"
                + "        select count(*)\n"
                + "        from bi_strategic.strategic_data_mng_apply_map_file f\n"
                + "        inner join bi_strategic.strategic_data_mng_apply_map_space s on f.space_id=s.id\n"
                + "        where f.file=#{name} and s.product_id=(select p.id\n"
                + "        from bi_strategic.strategic_data_mng_apply_map_product p\n"
                + "        inner join bi_strategic.strategic_data_mng_apply_map_space s on p.id=s.product_id\n"
                + "        where s.id=#{id}\n"
                + "        )\n"
                + "        group by f.file,s.product_id\n"
                + "        order by null\n"
                + "    </select>\n"
                + "\n"
                + "    <select id=\"selectDataNumBelowFile\" resultType=\"java.lang.Integer\">\n"
                + "        select count(*)\n"
                + "        from bi_strategic.strategic_data_mng_apply_map_file f\n"
                + "        inner join bi_strategic.strategic_data_mng_apply_map_table t on f.id=t.file_id\n"
                + "        where f.id=#{id}\n"
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
