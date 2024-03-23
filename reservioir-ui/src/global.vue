
<script type="text/javascript">
    // 定义一些公共的属性和方法
    import { Message } from 'element-ui';
    import {getToken} from "@/utils/auth";
    import {
        delFile
    } from "@/api/file";


    const httpUrl =  process.env.VUE_APP_BASE_API + '/file/upload'
    //const headers = {Authorization: "Bearer " + getToken()}
    function commonFun(fId) {
        console.log("公共方法",fId)
        var params = {
            id:fId,
        }
        if (fId) {
          delFile(params).then(res => {
            if (res.code === 200) {
              Message({
                showClose: true,
                message: '删除成功',
                 type: 'success'
              });
            }
          });
    }
    }
    function headers(){
    	return {Authorization: "Bearer " + getToken()};
    }
    // 暴露出这些属性和方法
    export default {
        httpUrl,
        headers,
        commonFun
    }
</script>;
