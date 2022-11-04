<#import "../../_layout.ftl" as layout />
<@layout.layout>
    <div>
        <h3>Create article</h3>
        <form action="/news" method="post">
            <p>
                <input type="text" name="title">
            </p>
            <p>
                <textarea name="body"></textarea>
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.layout>