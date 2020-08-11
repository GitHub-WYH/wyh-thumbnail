package com.wyh.tbl.service.impl;

import com.wyh.tbl.service.ThumbnailService;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ClassName: ThumbnailServiceImpl
 *
 * @Author: WangYiHai
 * @Date: 2020/8/11 15:46
 * @Description: TODO
 */
@Service
public class ThumbnailServiceImpl implements ThumbnailService {
    private static final Logger logger = LoggerFactory.getLogger(ThumbnailServiceImpl.class);
    
    /**
     * 指定大小进行缩放
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    @Override
    public void getThumbnailBySize(String filePath, Integer x, Integer y) throws IOException {
        File file = new File(filePath);
        String suffix = filePath.substring(filePath.indexOf("."), filePath.length());
        Thumbnails.of(filePath)
                .size(x, y)
                .toFile(file.getAbsolutePath() + "_"+ x + "x" + y + suffix);
    }

    /**
     * 不按比例，按大小缩放
     *
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    @Override
    public void getThumbnailBySizeNoScale(String filePath, Integer x, Integer y) throws IOException {
        File file = new File(filePath);
        String suffix = filePath.substring(filePath.indexOf("."), filePath.length());
        Thumbnails.of(filePath)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile(file.getAbsolutePath() + "_"+ x + "x" + y + suffix);

    }

    /**
     * 按比例缩放
     * @param filePath
     * @param x
     */
    @Override
    public void getThumbnailByScale(String filePath, float x) throws IOException {
        File file = new File(filePath);
        String suffix = filePath.substring(filePath.indexOf("."), filePath.length());
        Thumbnails.of(filePath)
                .scale(x)
                .toFile(file.getAbsolutePath() + "_"+x+"%"+suffix);

    }

    /**
     * 输出图片到流对象
     *
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    @Override
    public void getThumbnailToOs(String filePath, Integer x, Integer y) throws IOException {
        File file = new File(filePath);
        String suffix = filePath.substring(filePath.indexOf("."), filePath.length());
        OutputStream os = new FileOutputStream(file.getAbsolutePath() + "_OutputStream.png");
        Thumbnails.of(filePath)
                .size(x, y)
                .toOutputStream(os);

    }

    /**
     * 输出图片到BufferedImage
     *
     * @param filePath
     * @param x
     * @param y
     * @throws IOException
     */
    @Override
    public void getThumbnailToBi(String filePath, Integer x, Integer y) throws IOException {
        File file = new File(filePath);
        String suffix = filePath.substring(filePath.indexOf("."), filePath.length());
        BufferedImage thumbnail = Thumbnails.of(filePath)
                .size(x, y)
                .asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File(file.getAbsolutePath()+"_BufferedImage.jpg"));

    }
}