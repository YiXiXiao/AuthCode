## 验证码自动填写
验证码自动填写在很多地方使用。
如：登录注册、忘记密码、找回密码等等。应用场景在APP中是很常见的。
## Compile
添加依赖
#### Step 1.
```Groovy
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```
#### Step 2.
```Groovy
dependencies {
      compile 'com.github.YiXiXiao:AuthCode:V1.0.0'
}
```
## Sample
用法示例代码：
```java
CodeConfig config = new CodeConfig.Builder()
                        .codeLength(4) // 设置验证码长度
                        .smsFromStart(133) // 设置验证码发送号码前几位数字
                        //.smsFrom(1690123456789) // 如果验证码发送号码固定，则可以设置验证码发送完整号码
                        .smsBodyStartWith("百度科技") // 设置验证码短信开头文字
                        .smsBodyContains("验证码") // 设置验证码短信内容包含文字
                        .build();
AuthCode.getInstance().with(context).config(config).into(EditText);
````
## 注意事项：
添加权限
```Groovy
  <uses-permission android:name="android.permission.RECEIVE_SMS"/>
  <uses-permission android:name="android.permission.READ_SMS"/>
````
由于6.0以上权限需要动态申请权限，需要自行处理（如果没有做过可参考以下示例代码）
动态申请权限代码如下：
```java
/**
     * 简单处理了短信权限
     */
    private void handlePermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_SMS}, REQUEST_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length != 0) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "您阻止了app读取您的短信，你可以自己手动输入验证码", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
```


