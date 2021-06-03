package com.zhou.springboot.leqee;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

@SuppressWarnings("all")
public class ExcelProcess {

    private List<TagTree> leafTrees = new ArrayList<>();

    public void initFakeTree() {
        TagTree root = new TagTree("m2", "彩妆需求", 0, null, null);
        TagTree l1 = new TagTree("2.2", "质地", 0, root, null);
        TagTree l2 = new TagTree("2.2.2", "哑光", 1, l1, "哑光");
        leafTrees.add(l2);
    }

    public void initTree() {
//                readFile("/Users/hfzhou/Desktop/彩妆0422.json", "m");
//                readFile("/Users/hfzhou/Desktop/护肤0413.json", "s");
//        readFile("/Users/hfzhou/Desktop/通用维度0414.json", "g");
        readFile("/Users/hfzhou/Desktop/香水0425-1.json", "p");
    }

    private void readFile(String filePath, String type) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            int length = fis.available();
            byte[] bytes = new byte[length];
            fis.read(bytes);
            String s = new String(bytes);
            JSONObject jo = JSONObject.parseObject(s);

            recursive(jo, null, 1, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void recursive(JSONObject jo, TagTree parent, int index, String type) {
        String title = (String) jo.get("title");
        JSONArray topics = (JSONArray) jo.get("topics");

        int leaf = 0;
        String[] keywords = null;
        if (topics == null) {
            leaf = 1; //代表是叶子节点
            keywords = title.replaceAll("，", ",").split(",");
        }

        if (topics != null && topics.size() > 0) {
            for (int i = 0; i < topics.size(); i++) {
                TagTree tt;
                JSONObject ti = (JSONObject) topics.get(i);
                if (parent == null) {
                    tt = new TagTree(type + (i + 1), (String) ti.get("title"), leaf, null, keywords); //先生成当前节点的树
                } else {
                    tt = new TagTree((parent.getTagCode() + "." + (i + 1)), (String) ti.get("title"), leaf, parent,
                                     keywords); //先生成当前节点的树
                }
                recursive(topics.getJSONObject(i), tt, i + 1, type);
            }
        } else {
            //代表是叶子节点
            TagTree tt;
            tt = new TagTree(null, title, leaf, parent, keywords); //先生成当前节点的树
            leafTrees.add(tt);
        }
    }

    @Test
    public void process() {
        initTree();
        ExcelReadListener listener = new ExcelReadListener();
//        EasyExcel.read("/Users/hfzhou/Desktop/练习511.xlsx", listener).sheet().doRead();
        EasyExcel.read("/Users/hfzhou/Desktop/3label_chatting_perfume.xlsx", listener).sheet().doRead();

        List<MatchResult> results = listener.results;

        if (results.size() > 0) {
            String fileName = "/Users/hfzhou/Desktop/" + "simpleWrite" + System.currentTimeMillis()
                    + ".xlsx";
            EasyExcel.write(fileName, MatchResult.class).sheet("模板").excludeColumnFiledNames(new ArrayList<String>() {{
                add("leafTree");
            }}).doWrite(results);
        }

        System.out.println("识别率 ==> " + (float) listener.regCount / listener.count);
    }


    public class ExcelReadListener extends AnalysisEventListener<Map<Integer, String>> {

        public List<MatchResult> results = new ArrayList<>();

        public int count;
        public int regCount;

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        }

        @Override
        public void invoke(Map<Integer, String> data, AnalysisContext context) {
            String sentence = data.get(6); //sentence
            List<MatchResult> results = leafTrees.stream().map(t -> {
                String kw = t.matchKeyword(sentence);
                if (kw != null) {
                    return new MatchResult(sentence, kw, t);
                }
                return null;
            }).filter(t -> t != null).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(results)) {
                MatchResult emptyResult = new MatchResult(sentence, null, null);
                emptyResult.setCateCode(data.get(0));
                emptyResult.setGrouping(data.get(1));
                emptyResult.setLogid(data.get(2));
                emptyResult.setContent(data.get(3));
                emptyResult.setSid(data.get(4));
                emptyResult.setChatPerson(data.get(6));

                emptyResult.setFlagStatus(data.get(0));
                emptyResult.setCateCode1(data.get(1));
                emptyResult.set_id(data.get(2));
                emptyResult.setShopId(data.get(3));
                emptyResult.setChatperson(data.get(4));
                emptyResult.setChatrecord(data.get(5));
                emptyResult.setSentence(data.get(6));
                emptyResult.setItemid_0(data.get(7));
                emptyResult.setChattime(data.get(8));

                this.results.add(emptyResult);
            } else {
                Integer multi = results.size() == 1 ? null : 1;
                results.forEach(t -> {
                    t.setCateCode(data.get(0));
                    t.setGrouping(data.get(1));
                    t.setLogid(data.get(2));
                    t.setContent(data.get(3));
                    t.setSid(data.get(4));
                    t.setChatPerson(data.get(6));
                    t.setMulti(multi);

                    t.setFlagStatus(data.get(0));
                    t.setCateCode1(data.get(1));
                    t.set_id(data.get(2));
                    t.setShopId(data.get(3));
                    t.setChatperson(data.get(4));
                    t.setChatrecord(data.get(5));
                    t.setSentence(data.get(6));
                    t.setItemid_0(data.get(7));
                    t.setChattime(data.get(8));
                });
                this.results.addAll(results);
                regCount++;
            }
            count++;
        }

        private void setResult(MatchResult mr){

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {

        }
    }


}
