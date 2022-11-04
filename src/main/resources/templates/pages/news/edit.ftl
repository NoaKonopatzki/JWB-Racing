<#-- @ftlvariable name="news" type="de.nkono.models.News" -->
<#import "../../_layout.ftl" as layout />
<@layout.layout>
    <div>
        <h3>Edit article</h3>
        <form action="/news/${news.id}" method="post">
            <p>
                <input type="text" name="title" value="${news.title}">
            </p>
            <p>
                <textarea name="body">${news.body}</textarea>
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/news/${news.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.layout>