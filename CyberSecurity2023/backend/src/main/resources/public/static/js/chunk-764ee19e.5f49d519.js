(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-764ee19e"],{"09f3":function(e,t,o){},"371d":function(e,t,o){"use strict";o.r(t);var r=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"app-container"},[o("el-form",{ref:"form",attrs:{model:e.formModel,"label-width":"130px"}},[o("el-form-item",{attrs:{label:"Question title"}},[o("el-input",{model:{value:e.formModel.form_title,callback:function(t){e.$set(e.formModel,"form_title",t)},expression:"formModel.form_title"}})],1),o("el-form-item",{attrs:{label:"Question type"}},[o("el-select",{attrs:{placeholder:"please select question type"},model:{value:e.formModel.form_type,callback:function(t){e.$set(e.formModel,"form_type",t)},expression:"formModel.form_type"}},[o("el-option",{attrs:{label:"Usability",value:"Usability"}}),o("el-option",{attrs:{label:"Improvement",value:"Improvement"}})],1)],1),o("el-form-item",{attrs:{label:"Leave a message"}},[o("el-input",{attrs:{type:"textarea"},model:{value:e.formModel.form_message,callback:function(t){e.$set(e.formModel,"form_message",t)},expression:"formModel.form_message"}})],1),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("Send")]),o("el-button",{on:{click:e.onCancel}},[e._v("Clear")])],1)],1)],1)},m=[],l=o("b775"),s={submitForm:function(e){return Object(l["a"])({url:"/api/form/submit",config:"get",params:{form_title:e.form_title,form_type:e.form_type,form_message:e.form_message}})}},i={data:function(){return{formModel:{form_title:"a",form_type:"",form_message:"b"}}},methods:{onSubmit:function(){this.$message("submit!"),this.submitForm(this.formModel),this.formModel.form_title="",this.formModel.form_type="",this.formModel.form_message=""},onCancel:function(){this.formModel.form_title="",this.formModel.form_type="",this.formModel.form_message="",this.$message({message:"cancel!",type:"warning"})},submitForm:function(e){s.submitForm(e).then((function(e){}))}}},f=i,a=(o("e90f"),o("2877")),n=Object(a["a"])(f,r,m,!1,null,"fd544c40",null);t["default"]=n.exports},e90f:function(e,t,o){"use strict";o("09f3")}}]);