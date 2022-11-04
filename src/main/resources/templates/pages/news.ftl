<#-- @ftlvariable name="news" type="kotlin.collections.List<de.nkono.models.News>" -->
<#import "../_layout.ftl" as layout />
<@layout.layout>
    <link rel="stylesheet" href="/utils/css/news.min.css">

    <div class="sections">
        <#list news?reverse as news>
            <section class="article">
                <a class="article-link" href="/news/${news.id}">
                    <div class="article-content">
                        <h3 class="article-header">
                            ${news.title}
                        </h3>
                        <p class="article-body">
                            ${news.body}
                        </p>
                    </div>
                </a>
            </section>
        </#list>
    </div>
</@layout.layout>