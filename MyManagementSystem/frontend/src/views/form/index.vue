<template>
  <div class="app-container">

    <el-form ref="form" :model="formModel" label-width="130px">
      <el-form-item label="Question title">
        <el-input v-model="formModel.form_title" />
      </el-form-item>

      <el-form-item label="Question type">
        <el-select v-model="formModel.form_type" placeholder="please select question type">
          <el-option label="Usability" value="Usability" />
          <el-option label="Improvement" value="Improvement" />
        </el-select>
      </el-form-item>

      <el-form-item label="Leave a message">
        <el-input v-model="formModel.form_message" type="textarea" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">Send</el-button>
        <el-button @click="onCancel">Clear</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import formApi from "@/api/form"

export default {
  data() {
    return {
      formModel: {
        form_title: '',
        form_type: '',
        form_message: ''
      }
    }
  },
  methods: {
    onSubmit() {
      this.$message("submit!")
      this.submitForm(this.formModel)
      this.formModel.form_title = ""
      this.formModel.form_type = ""
      this.formModel.form_message = ""
    },
    onCancel() {

      this.formModel.form_title = ""
      this.formModel.form_type = ""
      this.formModel.form_message = ""

      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    },
    submitForm(formModel){
        formApi.submitForm(formModel).then(response => {
          
        })
    }
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
</style>

