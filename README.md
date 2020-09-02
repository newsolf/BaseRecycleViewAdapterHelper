Powerful and flexible RecyclerView Adapter, Please feel free to use this. (Welcome to Star and Fork)

强大而灵活的RecyclerView Adapter（欢迎 Star 和 Fork）

Written using kotlin and AndroidX, Support java use.

使用kotlin和AndroidX编写，支持java使用。

#Step 1: 导入方式

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
#Setp 2:添加依赖项
>仅支持 Androidx ，基于 RecyclerView V1.1.0
```
dependencies {
    implementation 'com.github.NeWolf:BaseRecycleViewAdapterHelper:V1.0.0'
}
```
#Adapter 的使用

##BaseQuickAdapter
###1、快速使用
>BaseQuickAdapter<T, VH>为最基础的类型，直接使用BaseQuickAdapter<T, VH>即可简单快速实现一个Adapter：

```
public class DemoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    /**
     * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
     * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
     */
    public DemoAdapter(list List<String>) {
        super(R.layout.layout_demo, list);
    }

    /**
     * 在此方法中设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull String item) {
        helper.setText(R.id.tweetName, "This is an Item, pos: " + (helper.getAdapterPosition() - getHeaderLayoutCount()));
    }
}
```
Activity中设置：
```
DemoAdapter adapter = new DemoAdapter(new ArrayList<String>());
mRecyclerView.setAdapter(adapter);

 // 设置新的数据方法

adapter.setNewData(list)
```
###2、纯View创建Item
如果不想使用xml布局，想直接使用View代码方式创建，那么构造函数使用super(0)，并且在Adapter中重写onCreateDefViewHolder方法：
```
public class DemoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DemoAdapter(list List<String>) {
      	//布局传递0
      	super(0);
    }

    /**
     * 重写此方法，自己创建 View 用来构建 ViewHolder
     */
    @NotNull
    @Override
    protected BaseViewHolder onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
      	// 创建自己的布局
        FrameLayout layout = new FrameLayout(getContext());
        ...
        ...
        return createBaseViewHolder(layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, @NotNull String item) {
      	...
    }
}
```
###3、BaseQuickAdapter 点击事件
Item 点击事件
代码如下：
```
DemoAdapter adapter = new DemoAdapter();

// 设置点击事件
adapter.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
        Tips.show("onItemClick " + position);
    }
});
```
Item 长按事件
代码如下：
```
adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
        Tips.show("onItemLongClick " + position);
        return true;
    }
});
```
Item 内子View的点击事件：
>注意，请不要在convert方法里注册控件id
```
// 先注册需要点击的子控件id（注意，请不要写在convert方法里）
adapter.addChildClickViewIds(R.id.btn, R.id.iv_num_add, R.id.item_click);
// 设置子控件点击监听
adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
    @Override
    public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
        if (view.getId() == R.id.btn) {
            Tips.show("onItemChildClick " + position);
        }
    }
});
```
Item 内子View的长按事件：
>注意，请不要在convert方法里注册控件id

// 先注册需要长按的子控件id（注意，请不要写在convert方法里）
```
adapter.addChildLongClickViewIds(R.id.btn, R.id.iv_num_add, R.id.item_click);
// 设置子控件长按监听
adapter.setOnItemChildLongClickListener(new OnItemChildLongClickListener() {
    @Override
    public boolean onItemChildLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
        if (view.getId() == R.id.btn) {
           Tips.show("onItemChildLongClick " + position);
        }
        return true;
    }
});
```
##BaseMultiItemQuickAdapter
>所有的数据类型，都必须实现MultiItemEntity接口（注意，这里不是继承抽象类，而是实现接口，避免对业务的实体类带来影响）

```
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<QuickMultipleEntity, BaseViewHolder> {

    public MultipleItemQuickAdapter(List<QuickMultipleEntity> data) {
        super(data);
        // 绑定 layout 对应的 type
        addItemType(QuickMultipleEntity.TEXT, R.layout.item_text_view);
        addItemType(QuickMultipleEntity.IMG, R.layout.item_image_view);
        addItemType(QuickMultipleEntity.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, QuickMultipleEntity item) {
        // 根据返回的 type 分别设置数据
        switch (helper.getItemViewType()) {
            case QuickMultipleEntity.TEXT:
                helper.setText(R.id.tv, item.getContent());
                break;
            case QuickMultipleEntity.IMG_TEXT:
                ...
                ...
                break;
            default:
                break;
        }
    }
}
```
数据实体类写法：
```
class 你的数据实体类 implements MultiItemEntity {

  // 你的数据内容
  ...
  ...

  /**
   * 实现此方法，返回类型
   */
  @Override
    public int getItemType() {
        return itemType;
    }
}
```

#proguard-rules.pro

#Thanks
[CymChad/BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/README.md)

