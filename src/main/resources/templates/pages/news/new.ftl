<#import "../../_admin-layout.ftl" as layout />
<@layout.layout>
    <link rel="stylesheet" href="/utils/css/new.min.css">

    <div class="sec1">
        <div class="title">
            <h2>Create article</h2>
        </div>
        <form action="/news" method="post" class="form">
            <p>
                <input type="text" name="title" class="title-area" placeholder="Title">
            </p>
            <p>
                <textarea name="body" class="text-area" placeholder="News Message..."></textarea>
            </p>
            <p>
                <input type="submit" class="submit-button" value="Submit">
            </p>
        </form>
    </div>
</@layout.layout>