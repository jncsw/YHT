

var firstnum = 0;var secondnum = 0;
var errcod = 1;
var username="";
var password;
var userid;
var shuzushangxian = 200;
var mylablelist = [];

var joinlablelist = [];

var lablelist = [];

var page=1;
var myl = 0;
var joinl = 0;
var llist = 0;
var hash;
var x;
var y;
var mapObj;
var lnglatXY;
var myorjoin=0;

//初始化地图
function mapInit(){

	
    var opt = {  
        level: 18, //设置地图缩放级别    
        center: new AMap.LngLat(117.139743,36.667424), //设置地图中心点   
    }  
    mapObj = new AMap.Map("iMap", opt);  
    
    
    AMap.event.addListener(mapObj,'click',getLnglat); //点击事件
}


//鼠标点击，获取经纬度坐标  
function getLnglat(e){    
    // mapObj.clearMap();
    x = e.lnglat.getLng();
    y = e.lnglat.getLat(); 
    // document.getElementById("lnglat").innerHTML = x + "," + y;
    
    lnglatXY = new AMap.LngLat(x,y);
    
}

//一级菜单的登录按钮
function firstlistdenglu() {
	
  if (errcod==0) {$("#menu_first_denlutuichuanniu").attr("src","work/images/退出菜单.png");}
    else{$("#menu_first_denlutuichuanniu").attr("src","work/images/登录菜单.png");}

  
}
//一级二级菜单
$(document).ready(function(){

  $("#ico-2").click(function(){
    if (panduan()) {
      if (firstnum==0) {
    	 
        firstlistdenglu();
        $("#ico-1").css("display","none");
        $("#menu_first").animate({left:'0'},300);
        
        
      }
       firstnum = 2;
    
      setfirstlistcolor(firstnum);
       var nn = setsecondlist(secondnum,firstnum);
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });

  $("#ico-3").click(function(){
    if (panduan()) {
      if (firstnum==0) {
    	  
        firstlistdenglu();
        $("#ico-1").css("display","none");
        $("#menu_first").animate({left:'0'},300);
      }
       firstnum = 3;
   
      setfirstlistcolor(firstnum);
       var nn = setsecondlist(secondnum,firstnum);
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });
  $("#ico-4").click(function(){
    if (panduan()) {
      if (firstnum==0) {
    
        firstlistdenglu();
        $("#ico-1").css("display","none");
        $("#menu_first").animate({left:'0'},300);
      }
       firstnum = 5;
    
      setfirstlistcolor(firstnum);
       var nn = setsecondlist(secondnum,firstnum);
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });
  // 一级菜单出现和隐藏
	$("#ico-1").click(function(){
		$("#ico-1").css("display","none");
		//  alert("here");
    firstlistdenglu();
		$("#menu_first").animate({left:'0'},300);
    

	});
  $("#menu_first_img_image").click(function(){
    $("#ico-1").css("display","block");
    firstlistdenglu();
    $("#menu_first").animate({left:'-10%'},300);
    $("#menu_second").css({
      "display":"none",
      "left":"-3%"
    });
   // firstnum = 0;

  });
//二级菜单出现和隐藏

  $("#menu_first_list").click(function(){
    firstnum = 1;


    //////////////////////////此处需改
    if (panduan()) {

      setfirstlistcolor(firstnum);

      var nn = setsecondlist(secondnum,firstnum);
      
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });

  $("#menu_first_manage").click(function(){
    firstnum = 2;
    //////////////////////////此处需改
    if (panduan()) {
      setfirstlistcolor(firstnum);
       var nn = setsecondlist(secondnum,firstnum);
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });

  $("#menu_first_maker").click(function(){
    firstnum = 3;
    //////////////////////////此处需改
   if (panduan()) {
      setfirstlistcolor(firstnum);
       var nn = setsecondlist(secondnum,firstnum);
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });

  $("#menu_first_suggest").click(function(){
    firstnum = 4;
    //////////////////////////此处需改
    if (panduan()) {
      setfirstlistcolor(firstnum);
       var nn = setsecondlist(secondnum,firstnum);
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });

  $("#menu_first_myinfor").click(function(){
    firstnum = 5;
    //////////////////////////此处需改
   if (panduan()) {
      setfirstlistcolor(firstnum);
      var nn = setsecondlist(secondnum,firstnum);
      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });

  $("#menu_first_shezhi").click(function(){
    firstnum = 6;
    //////////////////////////此处需改
   if (panduan()) {
      setfirstlistcolor(firstnum);

       var nn = setsecondlist(secondnum,firstnum);

      if(nn==0||nn==2){secondnum = firstnum;}
      if (nn==1) { secondnum =0;}
    }
    else{
      firstnum = 0;
    }
  });
});

function setfirstlistcolor(num) {
  $("#menu_first_list").css("background","rgb(36,41,44)");
  $("#menu_first_manage").css("background","rgb(36,41,44)");
  $("#menu_first_maker").css("background","rgb(36,41,44)");
  $("#menu_first_suggest").css("background","rgb(36,41,44)");
  $("#menu_first_myinfor").css("background","rgb(36,41,44)");
  $("#menu_first_shezhi").css("background","rgb(36,41,44)");
  if(num==0){}
  else if(num==1){$("#menu_first_list").css("background","rgb(27,33,37)");}
  else if(num==2){$("#menu_first_manage").css("background","rgb(27,33,37)");}
  else if(num==3){$("#menu_first_maker").css("background","rgb(27,33,37)");}
  else if(num==4){$("#menu_first_suggest").css("background","rgb(27,33,37)");}
  else if(num==5){$("#menu_first_myinfor").css("background","rgb(27,33,37)");}
  else if(num==6){$("#menu_first_shezhi").css("background","rgb(27,33,37)");}
}
function panduan() {

  if(errcod== 1){
      $("#mask").css("display","block");
      $("#unlist").css("display","block");
      return false;
    }
    else return true;
}

function setsecondlist(num2,num1) {
  if(num2==0){
    if (num1==0) {}
    else if(num1==1){$("#menu_second_list").css("display","block");}
    else if(num1==2){$("#menu_second_manage").css("display","block");}
    else if(num1==3){$("#menu_second_maker").css("display","block");}
    else if(num1==4){$("#menu_second_suggest").css("display","block");$("#ico-2").css("display","none");$("#ico-3").css("display","none");}
    else if(num1==5){$("#menu_second_mynews").css("display","block");$("#ico-2").css("display","none");$("#ico-3").css("display","none");}
    else if(num1==6){$("#menu_second_user").css("display","block");$("#ico-2").css("display","none");$("#ico-3").css("display","none");}
    $("#menu_second").css("display","block");
    $("#menu_second").animate({left:'10%'},300);
    return 0;
  }
  else if(num1==num2&&num2!=0){
    $("#menu_second").animate({left:'-3%'},300);
    $("#menu_second").css("display","none");
    $("#menu_second_list").css("display","none");
    $("#menu_second_manage").css("display","none");
    $("#menu_second_maker").css("display","none");
    $("#menu_second_suggest").css("display","none");
    $("#menu_second_mynews").css("display","none");
    $("#menu_second_user").css("display","none");
    $("#ico-2").css("display","block");$("#ico-3").css("display","block");
    return 1;
  }
  else if (num1!=num2&&num2!=0) {
    
    $("#menu_second_list").css("display","none");
    $("#menu_second_manage").css("display","none");
    $("#menu_second_maker").css("display","none");
    $("#menu_second_suggest").css("display","none");
    $("#menu_second_mynews").css("display","none");
    $("#menu_second_user").css("display","none");

    if (num1==0) {}
    else if(num1==1){$("#menu_second_list").css("display","block");$("#ico-2").css("display","block");$("#ico-3").css("display","block");}
    else if(num1==2){$("#menu_second_manage").css("display","block");$("#ico-2").css("display","block");$("#ico-3").css("display","block");}
    else if(num1==3){$("#menu_second_maker").css("display","block");$("#ico-2").css("display","block");$("#ico-3").css("display","block");}
    else if(num1==4){$("#menu_second_suggest").css("display","block");$("#ico-2").css("display","none");$("#ico-3").css("display","none");}
    else if(num1==5){$("#menu_second_mynews").css("display","block");$("#ico-2").css("display","none");$("#ico-3").css("display","none");}
    else if(num1==6){$("#menu_second_user").css("display","block");$("#ico-2").css("display","none");$("#ico-3").css("display","none");}
    return 2;

  }
}

$(document).ready(function(){
  $("#unlist_lianjie_go").click(function() {
    $("#unlist").css("display","none");

    $("#mask").css("display","block");
    $("#login").css("display","block");
  });
});

$(document).ready(function(){
  //登录退出
  $("#login_tuichu").click(function () {
    $("#login").css("display","none");
    $("#mask").css("display","none");
  });
  //登录注册
  $("#login_register").click(function () {
    $("#register").css("display","block");
    $("#login").css("display","none");
  });
  //注册提交
   $("#register_tijiao").click(function () {
    register();
  });
   $("#register_imgtuichu").click(function () {
    $("#register").css("display","none");
    $("#login").css("display","block");
  });
});
$(document).ready(function(){
  $("#menu_first_denlutuichuanniu").click(function (){
    if($("#menu_first_denlutuichuanniu").attr("src")=="work/images/登录菜单.png"){
      $("#mask").css("display","block");
      $("#login").css("display","block");
    }
    else{
      quit();
    }
    // body...
  });

});
// $(document).ready(function(){
 

// });
/////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
//

function md5(pas) {
  var hash = hex_md5(pas);
  return hash;
}


function login() {
  var name;
  var Password;
  name = $("#username_l").val();
  Password = $("#password2_l").val();
  Password=hex_md5(Password);
  

  var aj = $.ajax( {  
    url:'Login',

    data:{  
             "username":name,
             "password2":Password,
             
             
      },  
    type:'post',  
    cache:true,  
    dataType:'json',  

    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          username = name;
          
          firstnum=1;
            alert("登陆成功");  
              
        }else{  
          errcod = 1;
            alert("登录失败");  
        }  
        firstlistdenglu();
    },  
     error : function() {  
          
          alert("服务异常!"); 
           
     }  
  });
    $("#login").css('display',"none");
    $('#unlist').css('display','none');
    $('#mask').css('display','none');
    

}
///退出登录
function quit() {
  errcod = 1;
  
  $("#menu_second_list").css("display","none");
  $("#menu_second_manage").css("display","none");
  $("#menu_second_maker").css("display","none");
  $("#menu_second_suggest").css("display","none");
  $("#menu_second_mynews").css("display","none");
  $("#menu_second_user").css("display","none");
  $("#menu_second").css("display","none");
  secondnum = 0;
  firstlistdenglu();

}


function register() {
  // alert("jdsjd");
  var name=null;
  var Password=null;
  var Password2=null;
  var re_name=null;
  var Email;
  var Phone;
  var Intro;
  name = $("#register_name").val();
  
  Password = $("#register_password").val();
  Password2 = $("#register_password2").val();
  re_name = $("#register_rename").val();
  Email = $("#register_email").val();
  Phone = $("#register_phone").val();
  Intro = $("#textarea").val();
  
  if (name==""||Password==null||Password2==null||re_name==null) {
    alert("请输入必填信息")

  }

  if (Password!=Password2) {
    alert("密码输入错误");
    return;
  }

  //Password = md5(Password);


  var aj = $.ajax( {  
    url:'Register',// 跳转到 action  
    data: "username="+name+"&password="+Password+"&real_name="+re_name+"&email="+Email+"&Email="+Phone+"&intro="+Intro,
      // "username" : name,
      // "password" :Password,
      // "real_name" :re_name,
      // "email" :Email,
      // "phone_number" :Phone,
      // "intro" :Intro,
             
        
    type:'POST', 
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          username = data.username;
          password = data.password;
          
            alert("注册成功");
            

              
        }else{  
          errcod = 1;
            alert("注册失败，用户名已存在");  
        }  
    },  
     error : function() {  
         
          alert("用户名已存在！");  
     }  
  });
  
    $("#register").css('display',"none");
    $("#mask").css('display',"none");
    firstlistdenglu();

  


}
// // 请求标签id

// 根据id请求详细信息
// function getdetilebyid(id) {
//    var aj = $.ajax( {  
//     url:'url',
//     data:{  
//       "label_id_g":id,
    
//       },  
//     type:'post',  
//     cache:false,  
//     dataType:'json',  
//     success:function(data) {  
//         if(data.errcode==0 ){
//           errcod = 0;
          
//         }else{  
//           errcod = 1;
            
//         }  
//     },  
//      error : function() {  
         
//           alert("服务异常！");  
//      }  
//   });
 
// }
// // //禁止空格

// // //创建标签
function creatLabel() {
  var Kind;
  var Joining_limit;
  var LoginX;
  var LoginY;
  var Place;
  var Start_time;
  var End_time;
  var Info;
  var Title;
  Kind = $("#menu_second_maker_form_family").val();
  Joining_limit =$("#menu_second_maker_peoplenum").val();
  LoginX =x;
  LoginY =y;
  Place =$("#menu_second_maker_place").val();
  Start_time =$("#menu_second_maker_time1").val();
  End_time =$("#menu_second_maker_time2").val();
  Info =$("#menu_second_maker_title").val();
  Title =$("#menu_second_maker_labeltitle").val();
  

  var aj = $.ajax( {  
    url:'url',// 跳转到 action  
    data:{  
      "kind":Kind,
        "jining_limit":Joining_limit,
        "loginX":LoginX,
        "loginY":LoginY,
        "place":Place,
        "start_time":Start_time,
        "end_time":End_time,
        "info":Info,
        "title":Title,

      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          
            
              
        }else{  
          errcod = 1;
            
        }  
    },  
     error : function() {  
         
          alert("异常！");  
     }  
  });
  if (errcod==0) {
    
  }
  else{
    
    alert("提交异常！");
  }


}
// //修改信息
function changeinfor() {
  var name;
  
  var re_name;
  var Email;
  var Phone;
  var Intro;
  name = $("#menu_second_user_xinxi_name").val();
  
  re_name = $("#menu_second_user_xinxi_rename").val();
  Email = $("#menu_second_user_xinxi_email").val();
  Phone = $("#menu_second_user_xinxi_phone").val();
  Intro = $("#menu_second_user_xinxi_info").val();
  

  var aj = $.ajax( {  
    url:'url',// 跳转到 action  
    data:{  
      "username":name,
      "real_name":re_name,
      "email":Email,
      "phone_number":Phone,
      "intro":Intro,
    
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          alert("修改成功！");
            
              
        }else{  
          errcod = 1;
            
        }  
    },  
     error : function() {  
          
          alert("异常！");  
     }  
  });
  if (errcod==0) {
   
  }
  else{
    
    alert("提交异常！");
  }


}
// // // //请求id列表
function GetLabelList(kind,lx,ly,d,t1,t2) {
    var Kind;
    var LoginX;
    var LoginY;
    var distance;
    var Start_time;
    var End_time;
    Kind = kind;
    LoginX =lx;
    LoginY =ly;
    Distance = d;
    Start_time = t1;
    End_time =t2;
  var aj = $.ajax( {  
    url:'url',
    data:{  
      "kind" : Kind,
      "loginX" :LoginX,
      "loginY" :LoginY,
      "distance" :Distance,
      "start_time" :Start_time,
      "end_time" : End_time,
    
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          
              lablelist = data.labelList;
          
        }else{  
          errcod = 1;
            
        }  
    },  
     error : function() {  
         
          alert("服务异常！");  
     }  
  });
  
}

// // // //地图放置标签
function getlableid1() {
    var idlisit = [];
    idlisit =liblelist;
    for (var i = 0 ; i < idlisit.lenth; i++) {
      setlableonmap(idlist[i]);
    }
}
// //转换类别
function lablek(k) {
  if(k==1){return "学术";}
  if (k==2) {return "宣讲";}
  if (k==3) {return "团队";}
  if (k==4) {return "比赛";}
  if (k==5) {return "宣传";}
  if (k==6) {return "活动";}
  if (k=="学术") {return 1;}
  if (k=="宣讲") {return 2;}
  if (k=="团队") {return 3;}
  if (k=="比赛") {return 4;}
  if (k=="宣传") {return 5;}
  if (k=="活动") {return 6;}

}
// //通过id在地图上生成标签
function setlableonmap(id) {
  var Kind;
  var lx;var ly;
  var aj = $.ajax( {  
    url:'url',
    data:{  
      "label_id_g":id,
    
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          Kind =data.kind;
          lx =data.locationX;
          ly =data.locationY;
        }else{  
          errcod = 1;
            
        }  
    },  
     error : function() {  
          alert("服务异常！");  
     }  
  });
  var ul ="work/images/";
  ul+=lablek(Kind)+"1.png";
  slnglatXY = new AMap.LngLat(lx,ly);

  var marker = new AMap.Marker({
        map:mapObj,
        
        icon: new AMap.Icon({
            image: ul,
          
        }),
        position: lnglatXY,
        offset: new AMap.Pixel(-5,-30),
    });
    mapObj.setFitView();
    marker.addEventListener("click", getlabledetil(id));
}
function getlabledetil(id) {
  var zhuangtai = 0;
  var time1 ;
  var time2 ;
  var Place ;
  var title ;
  var Kind ;
  var jlimit;
  var joinid =[];
  var aj = $.ajax( {  
    url:'url',
    data:{  
      "label_id_g":id,
    
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          time1 =data.start_time;
          time2 = data.end_time;
          Place = data.place;
          title =data.title;
          Kind = data.kind;
          jlimit =data.Joining_limit;
          joinid =data.joined_user;

        }else{  
          errcod = 1;
            
        }  
    },  
     error : function() {  
          alert("服务异常！");  
     }  
  });
  var d1 = new Date(time1);var d2 = new Date(time2);
  var t1 =d1.getMonth()+1+"月"+d1.getDate()+"日";
  var t2 =d2.getMonth()+1+"月"+d2.getDate()+"日";
  var ul ="work/images/"+lablek(Kind)+"图标.png";
  $("#mask").css("display","block");
  $("#lable_container_close").attr("src",ul);
  $("#lable_title").text(title);
  $("#lable_place").text(Place);
  $("#lable_starttime").text(t1+"至"+t2);
  $("#lable_info").text(title);
  $("#lable_joinlimit").text("参与人数上限为:"+jlimit);
  for(var i = 0;i<mylablelist.lenth;i++){
    if(id==mylablelist[i]){
      zhuangtai = 1;
    }
  }
  for(var i = 0;i<joinlablelist.lenth;i++){
    if(id==joinlablelist[i]){
      zhuangtai = 2;
    }
  }
  if(zhuangtai=0){
    
    $("#lable_oper").css("display","block");
    $("#lable_oper_my").css("display","none");
    $("#lable_oper_other_img").attr("src","work/images/未参与.png");
    $("#lable_oper_other_input").attr("src","work/images/我要参加.png");
    $("#lable_oper_other_input").click(function () {

      canyu(id);
      getlabledetil(id);
    });

  }
  if(zhuangtai=1){
    $("#lable_oper_my").css("display","none");
    $("#lable_oper").css("display","block");

    $("#lable_oper_other_img").attr("src","work/images/已经参与.png");
    $("#lable_oper_other_input").attr("src","work/images/取消参加.png");
    $("#lable_oper_other_input").click(function () {

      quxiaocanyu(id);
      getlabledetil(id);

    });

    
  }
  if(zhuangtai=2){
    $("#lable_oper_my").css("display","block");
    $("#lable_oper_my").click(function () {

      quxiaobiaoqian(id);
      getlabledetil(id);
    });
    
  }

  $("#lable_container").css("display","block");
}


function quxiaobiaoqian(id) {
  $.ajax({
    url:'url',
    data:{  
      "label_id_g":id,
    
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
        }
        else{
          errcod = 1;
        }
      }

  });
}
function canyu(id) {
  $.ajax({
    url:'url',
    data:{  
      "label_id_g":id,
    
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          
        }
        else{
          errcod = 1;
        }
      }
  });
}

function quxiaocanyu(id) {
  $.ajax({
    url:'url',
    data:{  
      "label_id_g":id,
    
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          
        }
        else{
          errcod = 1;
        }
      }

  });
}
// //参加取消残疾标签
// // $(document).ready(function(){
// //   $("#lable_oper_other_input").click(function() {
// //     if($("#lable_oper_other_input").attr("src") == "work/images/我要参加.png"){
// //       canyu()
// //     }
   
// //   });
// //   // body...
// // });
// //获取自己参与的标签
function getmylable() {
  $.ajax({
    url:'url',
    data:{  
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          mylablelist = data.joinedLabel;
          
        }
        else{
          errcod = 1;
        }
      }

  });


  // body...
}
// //获取自己发布的标签
function getjionlable() {
   $.ajax({
    url:'url',
    data:{  
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          joinlablelist = data.joinedLabel;    
        }
        else{
          errcod = 1;
        }
      }
  });
}



//点击地图图标获取标签
// function getmarkbyid(id) {
//   var idlisit = new Array();
//   idlisit[0] = id;

//   var aj = $.ajax( {  
//     url:'url',
//     data:{  
//       "LableID" : id,
    
//       },  
//     type:'post',  
//     cache:false,  
//     dataType:'json',  
//     success:function(data) {  
//         if(data.errcode==0 ){
//           errcod = 0;

//           var laball = data.labinfo;  
//           for (var i = 0; i < laball.lenth; i++) {
//             saeviewlabledetail(laball);
//           }
              
//         }else{  
//           errcod = 1;
            
//         }  
//     },  
//      error : function() {  
//           // view("异常！");  
//           alert("异常！");  
//      }  
//   });
// }



//标签列表生成
var nx;var ny;
$(document).ready(function() {
  $("#menu_second_list_find_img").click(function () {
     var kind = $("#menu_second_list_find_kind").val;
    getLocation();
    var D = $("#menu_second_list_find_dis").val/111000;
    var T = new Date();var T1 =T.gettime()-$("#menu_second_list_find_time").val*3600000;
    var T2 =T1+200000000;

    GetLabelList(kind,nx,ny,D,T1,T2);
    page=1;
    placelableonlist();
  });
});
function getLocation(){
 navigator.geolocation.getCurrentPosition(showPosition);
}
function showPosition(position){
  nx=position.coords.latitude;ny =position.coords.longitude;

}
function placelableonlist(){
  for(var i = 1;i<=6;i++){
    var time1;
    var time2;
    var Place;
    var title;
    var Kind;
    var jlimit;
    var joinid;
     $.ajax({
    url:'url',
    data:{  
      "label_id_g":labellist[i*page],
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          time1 =data.start_time;
          time2 = data.end_time;
          Place = data.place;
          title =data.title;
          Kind = data.kind;
          jlimit =data.Joining_limit;
          
          
        }
        else{
          errcod = 1;
        }
      }

  });
      var d1 = new Date(time1);var d2 = new Date(time2);
      var t1 =d1.getMonth()+1+"月"+d1.getDate()+"日";
      var t2 =d2.getMonth()+1+"月"+d2.getDate()+"日";
      var ul ="work/images/"+lablek(Kind)+".png";
      var ulimg ="#menu_second_list_"+i+"_img";
      var ultil ="#menu_second_list_"+i+"_title";
      var ultime ="#menu_second_list_"+i+"_time";
      var ulplace ="#menu_second_list_"+i+"_place";
     $(ulimg).attr("src",ul);
     $(ultil).text(title);
     $(ultime).text(t1+"至"+t2);
     $(ulplace).text(Place);
     

  }
  $("#menu_second_list_change_left").click(function () {
    if (page>1) {
    page-=1;
    
      placelableonlist();
    }
  });
  $("#menu_second_list_change_right").click(function () {
    if (page*6+6<labellist.lenth) {
        page+=1;
    
      placelableonlist();
    }
  });
}

// //////////
var mx;var my;
$(document).ready(function() {
  $("#ico-3").click(function () {
    page = 1;
    placemylableonlist();

    
  });
  $("#menu_first_manage").click(function () {
    page = 1;
    placemylableonlist(); 
  });
    


  
});

function placemylableonlist(){
  for(var i = 1;i<=6;i++){
    var time1;
    var time2;
    var Place;
    var title;
    var Kind;
    var jlimit;
    var joinid;
     $.ajax({
    url:'url',
    data:{  
      "label_id_g":myList[i*page],
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          time1 =data.start_time;
          time2 = data.end_time;
          Place = data.place;
          title =data.title;
          Kind = data.kind;
          jlimit =data.Joining_limit;
          
          
        }
        else{
          errcod = 1;
        }
      }

  });
     var d1 = new Date(time1);var d2 = new Date(time2);
    var t1 =d1.getMonth()+1+"月"+d1.getDate()+"日";
    var t2 =d2.getMonth()+1+"月"+d2.getDate()+"日";
     var ul ="work/images/"+lablek(Kind)+".png";
     var ulimg ="#menu_second_manage_"+i+"_img";
     var ultil ="#menu_second_manage_"+i+"_title";
     var ultime ="#menu_second_manage_"+i+"_time";
     var ulplace ="#menu_second_manage_"+i+"_place";
     $(ulimg).attr("src",ul);
     $(ultil).text(title);
     $(ultime).text(t1+"至"+t2);
     $(ulplace).text(Place);
     

  }
  $("#menu_second_manage_change_left").click(function () {
    if (page>1) {
    page-=1;
    
      placemylableonlist();
    }
  });
  $("#menu_second_list_change_right").click(function () {
    if (page*6+6<labellist.lenth) {
        page+=1;
    
      placemylableonlist();
    }
  });
}
$(document).ready(function () {
  $("#menu_second_manage_mytopart_right").click(function () {
    if (myorjoin==0) {
      myorjoin=1;
      placejoinlable();
      page = 1;
    }
    else{
      myorjoin=0;

      page = 1;
      placemylableonlist();
    }

    
  });
  
});
// ///////
function placejoinlable(){
  for(var i = 1;i<=6;i++){
    var time1;
    var time2;
    var Place;
    var title;
    var Kind;
    var jlimit;
    var joinid;
     $.ajax({
    url:'url',
    data:{  
      "label_id_g":myList[i*page],
      },  
    type:'post',  
    cache:false,  
    dataType:'json',  
    success:function(data) {  
        if(data.errcode==0 ){
          errcod = 0;
          time1 =data.start_time;
          time2 = data.end_time;
          Place = data.place;
          title =data.title;
          Kind = data.kind;
          jlimit =data.Joining_limit;
          
          
        }
        else{
          errcod = 1;
        }
      }

  });
     var d1 = new Date(time1);var d2 = new Date(time2);
    var t1 =d1.getMonth()+1+"月"+d1.getDate()+"日";
    var t2 =d2.getMonth()+1+"月"+d2.getDate()+"日";
     var ul ="work/images/"+lablek(Kind)+".png";
     var ulimg ="#menu_second_manage_"+i+"_img";
     var ultil ="#menu_second_manage_"+i+"_title";
     var ultime ="#menu_second_manage_"+i+"_time";
     var ulplace ="#menu_second_manage_"+i+"_place";
     $(ulimg).attr("src",ul);
     $(ultil).text(title);
     $(ultime).text(t1+"至"+t2);
     $(ulplace).text(Place);
     

  }
  $("#menu_second_manage_change_left").click(function () {
    if (page>1) {
    page-=1;
    
      placejoinlable();
    }
  });
  $("#menu_second_list_change_right").click(function () {
    if (page*6+6<labellist.lenth) {
        page+=1;
    
      placejoinlable();
    }
  });
}