package com.zhou.springboot.elasticsearch;

import java.io.IOException;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.fst.Builder;
import org.apache.lucene.util.fst.FST;
import org.apache.lucene.util.fst.FST.INPUT_TYPE;
import org.apache.lucene.util.fst.PositiveIntOutputs;
import org.apache.lucene.util.fst.Util;

public class FSTTest {

    public static void main(String[] args) throws IOException {
        String[] inputValues = {"cat", "deep", "do", "dog", "dogs"};
        long outputValues[] = {5, 7, 17, 18, 21};
        PositiveIntOutputs outputs = PositiveIntOutputs.getSingleton();
        Builder<Long> builder = new Builder<Long>(INPUT_TYPE.BYTE1, outputs);

        BytesRef scratchBytes = new BytesRef();
        IntsRef scratchInts = new IntsRef();

        for (int i = 0; i < inputValues.length; i++) {
            //            scratchBytes.
            //Util.toIntsRef(scratchBytes, scratchInts)

            //scratchInts.
            builder.add(scratchInts, outputValues[i]);
        }

        FST<Long> fst = builder.finish();
        Long value = Util.get(fst, new BytesRef("dog"));
        System.out.println(value);

    }

}
