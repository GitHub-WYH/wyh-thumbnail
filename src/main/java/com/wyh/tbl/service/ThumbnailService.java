package com.wyh.tbl.service;

import java.io.IOException;

/**
 * ClassName: ThumbnailService
 *
 * @Author: WangYiHai
 * @Date: 2020/8/11 15:46
 * @Description: TODO
 */
public interface ThumbnailService {

    /**
     * 按大小缩放
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    void getThumbnailBySize(String filePath, Integer x, Integer y) throws IOException;

    /**
     * 不按比例，按大小缩放
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    void getThumbnailBySizeNoScale(String filePath, Integer x, Integer y) throws IOException;

    /**
     * 按比例缩放
     * @param filePath
     * @param x
     * @throws IOException
     */
    void getThumbnailByScale(String filePath, float x) throws IOException;

    /**
     * 输出图片到流对象
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    void getThumbnailToOs(String filePath, Integer x, Integer y) throws IOException;

    /**
     * 输出图片到BufferedImage
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    void getThumbnailToBi(String filePath, Integer x, Integer y) throws IOException;



}