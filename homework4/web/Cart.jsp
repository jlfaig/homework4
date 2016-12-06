<%--
Copyright: 2016 Jenny Faig & William Breen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<section>
<h2 class="cartHeading">Currently checked out books</h2>

<table>
    
    <tr class="headers">
        <th class="patron">Patron Name</th>
        <th class="email">Email Address</th>
        <th>Book Title</th>
        <th>Due Date</th>
        <th>Overdue</th>
        <th></th>
    </tr>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.firstName} ${book.lastName}</td>
            <td>${book.email}</td>
            <td>${book.title}</td>
            <td>${book.formatDate}</td>
            <td>
                <c:if test="${book.isOverdue == true}">
                    <p>overdue</p>
                </c:if></td>
            <td>
                <form action="library?action=deleteBook" method="post">
                    <input type="hidden" name="bookId" value="${book.bookId}">
                    <input type="submit" value="Check in">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
    
    <p class="backLink"><a href="library?action=join"><b>Return to front page</b></a></p>
</section>

<c:import url="/includes/footer.html" />