<html>
<head>
    <title>${title}</title>
        </head>
        <body>
        <h1>${title}</h1>

        <ul>
        <#list items as item>
            <li>${item.getId()}. ${item.getName()} from ${item.getLocation()}</li>
        </#list>
        </ul>

        </body>
        </html>