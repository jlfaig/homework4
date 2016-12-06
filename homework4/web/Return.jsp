<%--
Copyright: 2016 Jenny Faig & William Breen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

  <section>
      <p class="response">
        Thank you for your patronage of the Belk Library. You've successfully
        checked out the book, ${user.title}. Please note that this book is due
        back on ______. A friendly reminder will be sent to you if your book 
        becomes overdue.
    </p>
    <p class="backLink"><a href="library?action=calculate_date"><b>Return to front page</b></a></p>
</section>

<c:import url="/includes/footer.html" />
