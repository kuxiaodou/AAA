package com.aaa.infomation.controller;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class FileUploadController {
    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     *
     * @author 豆豆(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("files") MultipartFile files, HttpServletRequest request) {
        /*if (!file.isEmpty()&&!files.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                //BufferedOutputStream out = new BufferedOutputStream(
                //      new FileOutputStream(new File(file.getOriginalFilename())));
                String upl=request.getSession().getServletContext().getRealPath("/")+"images/";
                File dir=new File(upl);
                String name=file.getOriginalFilename();
                String uuids= UUID.randomUUID().toString()+name.substring(name.lastIndexOf("."));
                System.out.println(uuids);
                File ser=new File(upl+uuids);
                file.transferTo(ser);

                String upls=request.getSession().getServletContext().getRealPath("/")+"video/";
                File dirs=new File(upl);
                String names=file.getOriginalFilename();
                //String uuidss= UUID.randomUUID().toString()+names.substring(names.lastIndexOf("."));
                String uuidss=UUID.randomUUID().toString()+".mp4";
                System.out.println(uuids);
                File sers=new File(upls+uuidss);
                files.transferTo(sers);
                //out.write(file.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }*/
        return  "";
    }
}
