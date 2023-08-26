package com.example.myapplication.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ArticalEntity

class ArticalViewModel:ViewModel() {

    //文章列表数据
    var articleList= listOf(ArticalEntity("《伊苏》和《轨迹》将推出主题桌游,马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游,马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2"),
        ArticalEntity("《伊苏》和《轨迹》将推出主题桌游，马里奥派对将于八月中旬开始打折","Jump小酱","2023.8.2")
    )

        private set
    //HTML 头部
    private val htmlHeader = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title></title>
            <style>
                img {
                    max-width: 100% !important;
                }
            </style>
        </head>
        <body>
    """.trimIndent()

    //html尾部
    private val htmlFooter = """
        </body>
        </html>
    """.trimIndent()

    var content =(
        """${htmlHeader}
            
            <div class="article-page">


                <script>
                var _hmt = _hmt || [];
                (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?60feaeb8bdcc7fbbc6e8bedcc72ae9e0";
                var s = document.getElementsByTagName("script")[0]; 
                s.parentNode.insertBefore(hm, s);
                })();
            </script>
            <script>
                var _report = _report || [];
                _report.push(['_setAccount', 'dc3f241db204d00b0a8b7103895312c4']);

                    _report.push(['_setCustomVar', 1, 'custom1', '4ECfV7yUSjA']);
                _report.push(['_setCustomVar', 2, 'custom2', '女足世界杯英格兰队与西班牙队争冠，苏纳克晒图祝“三狮军团”好运']);
                _report.push(['_setCustomVar', 3, 'custom3', '好运,英格兰队,英国,20,女足,10,纳克,观战']);
                _report.push(['_setCustomVar', 4, 'custom4', '环球网']);
                _report.push(['_setCustomVar', 5, 'custom5', '国际新闻']);
                _report.push(['_setCustomVar', 6, 'custom6', '国际新闻:独家']);
                _report.push(['_setCustomVar', 7, 'custom7', '魏少璞']);
                _report.push(['_setCustomVar', 8, 'custom8', '1']);
                
                (function() {
                    var report = document.createElement("script");
                    report.src = "https://analysis.huanqiu.com/better-report.js?id=e547964db520191b45ed";
                    var s = document.getElementsByTagName("script")[0];
                    s.parentNode.insertBefore(report, s);
                })();
            </script>
            <!-- Global site tag (gtag.js) - Google Analytics -->
            <script async src="https://www.googletagmanager.com/gtag/js?id=UA-124922893-1"></script>
            <script>
              window.dataLayer = window.dataLayer || [];
              function gtag(){dataLayer.push(arguments);}
              gtag('js', new Date());

              gtag('config', 'UA-124922893-1');
            </script>

                <!-- 公共头部分 begin -->
                <div class="topIndex">
                    <div class="hdTop">
                        <div class="hdTopCon navTopSec main">
                            <div class="leftNavSec"> 
                            <a href="https://www.ilive.cn" target="_blank" class="linkHome">
                                <img class="logo" src="https://rs2.huanqiucdn.cn/3w/images/touyibo.png" alt="" />
                            </a>

                            <a target="_blank" class="items" href="https://world.huanqiu.com/" style="padding-left: 3px;">国际</a>
                            <a target="_blank" class="items" href="https://mil.huanqiu.com/">军事</a>
                            <a target="_blank" class="items" href="https://society.huanqiu.com/">社会</a>
                            <a target="_blank" class="items" href="https://health.huanqiu.com/">健康</a>
                            <a target="_blank" class="items" href="https://tech.huanqiu.com/">科技</a>
                            <a href="https://www.huanqiu.com" target="_blank" class="header-logo"><i class="iconfont icon-home4"></i><i class="iconfont icon-LOGO"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div class="main clear">
                        <div class="m-content" id="content">
                            
                        <script type="text/javascript" src="//himg2.huanqiu.com/statics/3w/v2/dist/js/detected_block.js?tid=aa_right_1&color=#d63636"></script>
                    <div class="content-a" id="article">
                    <h1 class="a-title">
                        <strong>女足世界杯英格兰队与西班牙队争冠，苏纳克晒图祝“三狮军团”好运</strong></h1>
                    <div class="a-info">
                        <span class="time">2023-08-20 17:55</span>

                                    <span class="source">环球网</span>
                        
                    </div>
                    <div class="a-con">
                                        <p>【环球网报道】北京时间20日18点，2023女足世界杯将迎来最终决战，两支此前从未晋级过女足世界杯决赛的球队——英格兰队与西班牙队，向着冠军发起冲击。20日赛前，英国首相苏纳克在社交平台X（原推特）发布唐宁街10号大门照片，向“三狮军团”表示支持，并祝福好运。</p><p><img  alt="苏纳克推文截图"  src="https://rs-channel.huanqiucdn.cn/imageDir/b7e7f1e0d8ef498ea32f6e78cf770ba2u1.png"  data-upload-link="%7B%22cover%22%3A%22%22%2C%22desc%22%3A%221.png%22%2C%22id%22%3A%22b7e7f1e0d8ef498ea32f6e78cf770ba2u1%22%2C%22size%22%3A838.76%2C%22width%22%3A884%2C%22height%22%3A878%2C%22url%22%3A%22https%3A%2F%2Fm1-1253159997.image.myqcloud.com%2FimageDir%2Fb7e7f1e0d8ef498ea32f6e78cf770ba2u1.png%22%2C%22tags%22%3A%5B%5D%2C%22time%22%3A%222023-08-20%2017%3A55%3A18%22%2C%22mime%22%3A%22image%2Fpng%22%7D" /></p><p>这张照片的图说写道，“10号门上有三个狮子头门环，信箱上写着‘好运’”。</p><p>值得注意的是，据英国天空新闻网等英媒报道，苏纳克已决定不前往澳大利亚悉尼现场观看这场决赛，而是派英国外交大臣克莱弗利与英国文化、媒体和体育大臣露西·弗雷泽代表英政府现场观战，此举在英国内受到批评。此外，作为英格兰足球总会主席，英国威廉王子也因未能到现场观战受到批评，当地时间19日他在一段视频中表达歉意，祝福英格兰队好运。</p>
                                </div>

                    <div class="a-edit"><span class="a">责编：魏少璞</span></div>
                                <div class="a-sign"><p>版权作品，未经环球网 huanqiu.com 书面授权，严禁转载，违者将被追究法律责任。</p></div>
                    
                    
                    
                                
                        
                        <div class="aa-item mtb30" id="aa_comment_1">
                            
                        </div>
                        </div>
                        </div>
                        <div class="m-side-bar" id="sideBar">
                            <div class="side-bar-con">
                                                        
                                    <div id="hotbox-block"></div>

                                    <div class="s-c" id="hotLists">
                                        <div class="box">
                                            <h2 class="title"><strong>热门文章</strong></h2>
                                            <div class="bd"></div>
                                        </div>
                                    </div>

                                    <div class="aa-item mtb30" id="aa_right_1">
                                        <!-- 右侧广告 01-->
                                        <div class="_ddruwklej7g"></div> <script type="text/javascript"> (window.slotbydup = window.slotbydup || []).push({ id: "u6856471", container: "_ddruwklej7g", async: true }); </script>
                                    </div>

                                    <div class="s-a" id="hotPics">
                                        <div class="box">
                                            <h2 class="title"><strong>相关文章</strong></h2>
                                            <ul class="bd"></ul>
                                            <div class="aa-item mtb30" id="aa_right_2">
                                                <!-- 右侧广告 02-->
                                                
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="s-b" id="hotNews">
                                        <div class="box">
                                            <h2 class="title"><strong>今日热点</strong></h2>
                                            <div class="bd"></div>
                                        </div>
                                    </div>
                                                </div>
                        </div>
                    </div>
                </div>
            </div>${htmlFooter}
    """.trimIndent()
    )

}