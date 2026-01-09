<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>All Employees</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- Tailwind CSS CDN -->
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 min-h-screen p-6">

    <div class="max-w-7xl mx-auto bg-white p-6 rounded-lg shadow-md">

        <!-- Header -->
        <div class="flex justify-between items-center mb-6">
            <h1 class="text-2xl font-bold text-gray-700">Employee List</h1>

            <a href="${pageContext.request.contextPath}/addEmployee"
               class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition">
                + Add Employee
            </a>
        </div>

        <!-- Table -->
        <div class="overflow-x-auto">
            <table class="min-w-full border border-gray-300">
                <thead class="bg-gray-200">
                    <tr>
                        <th class="border px-4 py-2 text-left">Name</th>
                        <th class="border px-4 py-2 text-left">Job Title</th>
                        <th class="border px-4 py-2 text-left">Department</th>
                        <th class="border px-4 py-2 text-left">Role</th>
                        <th class="border px-4 py-2 text-left">Salary</th>
                        <th class="border px-4 py-2 text-left">Gender</th>
                        <th class="border px-4 py-2 text-left">Email</th>
                        <th class="border px-4 py-2 text-left">Mobile</th>
                        <th class="border px-4 py-2 text-center">Actions</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="emp" items="${employees}">
                        <tr class="hover:bg-gray-100">
                            <td class="border px-4 py-2">${emp.name}</td>
                            <td class="border px-4 py-2">${emp.jobTitle}</td>
                            <td class="border px-4 py-2">${emp.department}</td>
                            <td class="border px-4 py-2">${emp.role}</td>
                            <td class="border px-4 py-2">${emp.salary}</td>
                            <td class="border px-4 py-2">${emp.gender}</td>
                            <td class="border px-4 py-2">${emp.email}</td>
                            <td class="border px-4 py-2">${emp.mobileNo}</td>

                            <td class="border px-4 py-2 text-center space-x-2">
                                <a href="${pageContext.request.contextPath}/getEmployee/${emp.id}"
                                   class="text-blue-600 hover:underline">
                                    View
                                </a>
                                |
                                <a href="${pageContext.request.contextPath}/editEmployee/${emp.id}"
                                   class="text-yellow-600 hover:underline">
                                    Edit
                                </a>
                                |
                                <a href="${pageContext.request.contextPath}/deleteEmployee/${emp.id}"
                                   class="text-red-600 hover:underline"
                                   onclick="return confirm('Are you sure you want to delete this employee?');">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</body>
</html>
