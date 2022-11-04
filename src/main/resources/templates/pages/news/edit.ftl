<#-- @ftlvariable name="news" type="de.nkono.models.News" -->
<#import "../../_admin-layout.ftl" as layout />
<@layout.layout>
    <link rel="stylesheet" href="/utils/css/new.min.css">

    <div class="sec1">
        <div class="title">
            <h2>Edit article</h2>
        </div>
        <form action="/news/${news.id}" method="post" class="form">
            <p>
                <input type="text" name="title" class="title-area" value="${news.title}">
            </p>
            <p>
                <textarea name="body" class="text-area">${news.body}</textarea>
            </p>
            <p>
                <input type="submit" name="_action" class="submit-button" value="Update">
            </p>
        </form>
        <form action="/news/${news.id}" method="post" class="form">
            <p>
                <input type="submit" class="delete-button" name="_action" value="Delete">
            </p>
        </form>
    </div>
</@layout.layout>