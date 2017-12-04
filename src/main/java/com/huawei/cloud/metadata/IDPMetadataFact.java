package com.huawei.cloud.metadata;

import com.huawei.cloud.util.FileUtil;

/**
 * Created by zhouyibin on 2017/12/5.
 */
public class IDPMetadataFact {

    private static final String IDP_METADATA_PATH = IDPMetadataFact.class.getClassLoader().getResource("idp-metadata.xml").getPath();

    public static void main(String[] args) {
        String str = FileUtil.readFile(IDP_METADATA_PATH);
        System.out.println(str);
    }

}
