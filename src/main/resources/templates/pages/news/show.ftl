<#-- @ftlvariable name="news" type="de.nkono.models.News" -->
<#import "../../_layout.ftl" as layout />
<@layout.layout>
    <div>
        <h3>
            ${news.title}
        </h3>
        <p>
            ${news.body}
        </p>
        <hr>
        <p>
            <a href="/admin/${news.id}/edit">Edit article</a>
        </p>
    </div>
</@layout.layout>