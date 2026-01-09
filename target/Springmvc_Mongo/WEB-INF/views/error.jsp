<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>

<body class="bg-gray-100 min-h-screen flex items-center justify-center">

<div class="bg-white p-8 rounded-xl shadow-md w-full max-w-md text-center">
    <h1 class="text-2xl font-bold text-red-600 mb-4">
        ${errorTitle}
    </h1>

    <p class="text-gray-700 mb-6">
        ${errorMessage}
    </p>

    <a href="${pageContext.request.contextPath}/dashboard"
       class="inline-block bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">
        Back to Employee List
    </a>
</div>

</body>
</html>
