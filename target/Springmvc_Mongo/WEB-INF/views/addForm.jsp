<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 min-h-screen flex items-center justify-center p-6">

    <div class="bg-white w-full max-w-3xl p-6 rounded-lg shadow-lg">

        <h2 class="text-2xl font-semibold text-gray-700 mb-6 text-center">
            Employee Form
        </h2>

		<form:errors path="*" cssClass="text-red-600 mb-2 block"/>
        <form:form method="post"
                   action="${pageContext.request.contextPath}/saveEmployee"
                   modelAttribute="employee"
                   class="space-y-4">

            <c:if test="${not empty employee.id}">
                <form:hidden path="id"/>
            </c:if>

            <div class="grid grid-cols-2 gap-4">

                <div>
                    <label class="block text-gray-600 mb-1">Name</label>
                    <form:input path="name"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                         <form:errors path="name" cssClass="text-red-500"/>
                </div>

                <div>
                    <label class="block text-gray-600 mb-1">Job Title</label>
                    <form:input path="jobTitle"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                        <form:errors path="jobTitle" cssClass="text-red-500"/>
                </div>

                <div>
                    <label class="block text-gray-600 mb-1">Department</label>
                    <form:input path="department"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                        <form:errors path="department" cssClass="text-red-500"/>
                </div>

                <div>
                    <label class="block text-gray-600 mb-1">Role</label>
                    <form:input path="role"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                        <form:errors path="role" cssClass="text-red-500"/>
                </div>

                <div>
                    <label class="block text-gray-600 mb-1">Salary</label>
                    <form:input path="salary"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                        <form:errors path="salary" cssClass="text-red-500"/>
                </div>

                <div>
                    <label class="block text-gray-600 mb-1">Gender</label>
                    <form:select path="gender"
                        class="w-full border rounded px-3 py-2 bg-white focus:outline-none focus:ring-2 focus:ring-blue-400">
                        <form:option value="">-- Select --</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                        <form:option value="Other">Other</form:option>
                    </form:select>
                    <form:errors path="gender" cssClass="text-red-500"/>
                </div>

                <div>
                    <label class="block text-gray-600 mb-1">Email</label>
                    <form:input path="email"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                        <form:errors path="email" cssClass="text-red-500"/>
                </div>

                <div>
                    <label class="block text-gray-600 mb-1">Mobile No</label>
                    <form:input path="mobileNo"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                        <form:errors path="mobileNo" cssClass="text-red-500"/>
                </div>

                <div class="col-span-2">
                    <label class="block text-gray-600 mb-1">Address</label>
                    <form:textarea path="address" rows="3"
                        class="w-full border rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                        <form:errors path="address" cssClass="text-red-500"/>
                </div>
            </div>

            <div class="flex justify-center gap-4 pt-4">
                <button type="submit"
                        class="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700 transition">
                    Save Employee
                </button>

                <a href="${pageContext.request.contextPath}/dashboard"
                   class="bg-gray-500 text-white px-6 py-2 rounded hover:bg-gray-600 transition">
                    Back
                </a>
            </div>

        </form:form>
    </div>

</body>
</html>
