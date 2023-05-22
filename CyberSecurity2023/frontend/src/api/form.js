import request from "@/utils/request"

export default{
    submitForm(formModel){
        return request({
            url:"/api/form/submit",
            config: 'get',
            params:{
                form_title: formModel.form_title,
                form_type: formModel.form_type,
                form_message: formModel.form_message
            }
        })
    }
}