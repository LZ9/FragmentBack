# fragment添加物理返回按钮监听
### 2016/12/19
最近在项目里遇到需要在fragment里监听物理返回键，自己想了个解决方案，在这里跟大家分享下。

大致逻辑是：
1. 基类的fragment实现物理返回按钮监听接口
2. 基类的activity重写onBackPressed()方法来判断activity里的fragment是否拦截了返回事件

对应Demo里面
- 基类fragment是BaseFragment
- 基类activity是BaseActivity
- 物理返回按钮监听接口是IFragmentBackPressed

我在CarrickFragment、LiverpoolFragment和LaLigaFragment分别做了返回键拦截，大家可以运行demo试试

如果大家有更棒的建议非常欢迎留言告诉我~

<(￣︶￣)>