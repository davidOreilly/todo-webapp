<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        Welcome ${name} <br />
        Now you can <a href="list-todos?name=${name}">manage your todos</a>
    </div>
<%@ include file="common/footer.jspf" %>