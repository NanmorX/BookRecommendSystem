<template>
  <body>
    <div class="cont">
      <div class="form sign-in">
        <h2>Welcome back,</h2>
        <label>
          <span>Username</span>
          <input type="username" v-model="loginForm.username"/>
        </label>
        <label>
          <span>Password</span>
          <input type="password" v-model="loginForm.password"/>
        </label>
        <br>
  <!--      <p class="forgot-pass">Forgot password?</p>-->
        <button type="button" class="submit" v-on:click="login">Sign in</button>
  <!--      <button type="button" class="fb-btn">Connect with <span>facebook</span></button>-->
      </div>
      <div class="sub-cont">
        <div class="img">
          <div class="img__text m--up">
            <h2>New here?</h2>
            <p>Sign up and discover great amount of new opportunities!</p>
          </div>
          <div class="img__text m--in">
            <h2>One of us?</h2>
            <p>If you already has an account, just sign in. We've missed you!</p>
          </div>
          <div class="img__btn" v-on:click="change">
            <span class="m--up">Sign Up</span>
            <span class="m--in">Sign In</span>
          </div>
        </div>
        <div class="form sign-up" style="padding: 57.5px 30px 0;">
          <h2>Time to feel like home,</h2>
          <label>
            <span>Username</span>
            <input type="text" v-model="signForm.username"/>
          </label>
          <label>
            <span>Email</span>
            <input type="email" v-model="signForm.email"/>
          </label>
          <label>
            <span>phone</span>
            <input type="phone" v-model="signForm.phone"/>
          </label>
          <label>
            <span>Password</span>
            <input type="password" v-model="signForm.password"/>
          </label>
          <button type="button" class="submit" v-on:click="register">Sign Up</button>
  <!--        <button type="button" class="fb-btn">Join with <span>facebook</span></button>-->
        </div>
      </div>
    </div>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      signForm: {
        username: '',
        password: '',
        email: '',
        phone: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      var _this = this
      console.log(this.$store.state)
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          console.log(successResponse)
          if (successResponse.data.code === 200) {
            _this.$store.commit('login', _this.loginForm)
            var path = this.$route.query.redirect
            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
          }
        })
        .catch(failResponse => {
          console.log(failResponse)
        })
    },
    register () {
      this.$axios
        .post('/login', {
          username: this.signForm.username,
          password: this.signForm.password,
          email: this.signForm.email,
          phone: this.signForm.phone
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          }
        })
        .catch(failResponse => {
        })
    },
    change () {
      document.querySelector('.cont').classList.toggle('s--signup')
      this.loginForm.username = ''
      this.loginForm.password = ''
      this.signForm.username = ''
      this.signForm.password = ''
      this.signForm.email = ''
      this.signForm.phone = ''
    }
  }
}
</script>

<style scoped lang="scss">
  @import "./styles/login.scss";
</style>
