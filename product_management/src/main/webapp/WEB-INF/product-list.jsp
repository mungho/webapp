<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 09/08/2025
  Time: 12:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <link rel="stylesheet" href="/boostrap/css/bootstrap.css">
    <link rel="stylesheet" href="/my-css/my-style.css">
</head>
<body>
<div class="container-fluid custom-container mt-4">
    <div class="row mb-4">
        <div class="col">
            <h2>Product Management</h2>
        </div>
        <div class="col-auto">

            <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#addProductModal">
                Add Product
            </button>

<%--            <div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--                <div class="modal-dialog">--%>
<%--                    <div class="modal-content">--%>
<%--                        <div class="modal-header">--%>
<%--                            <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>--%>
<%--                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                        </div>--%>
<%--                        <div class="modal-body">--%>
<%--                            <form id="addProductForm" action="/product-list?action=add" method="post">--%>
<%--                                <input type="hidden" name="action" value="add">--%>
<%--                                <table class="w-100">--%>
<%--                                    <tr>--%>
<%--                                        <td class="col-4">Product's Name</td>--%>
<%--                                        <td class="col-8"><input name="name" type="text" class="form-control"></td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <td>Price</td>--%>
<%--                                        <td><input name="price" type="number" class="form-control"></td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <td>Stock</td>--%>
<%--                                        <td><input name="stock" type="number" class="form-control"></td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <td>Product Type</td>--%>
<%--                                        <td>--%>
<%--                                            <select id="productType" name="productType">--%>
<%--                                                <c:forEach var="type" items="${listProductType}">--%>
<%--                                                    <option value="${type.id}">${type.name}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                        </td>--%>
<%--                                    </tr>--%>
<%--                                </table>--%>
<%--                            </form>--%>
<%--                        </div>--%>
<%--                        <div class="modal-footer">--%>
<%--                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                            <button type="submit" form="addProductForm" class="btn btn-primary">Save</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <!-- Add Product Modal -->
            <div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="addProductLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header">
                            <h5 class="modal-title" id="addProductLabel">Add New Product</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <form id="addProductForm" action="${pageContext.request.contextPath}/product-list" method="post">
                            <input type="hidden" name="action" value="add">

                            <div class="modal-body">
                                <div class="mb-3">
                                    <label class="form-label">Product's Name</label>
                                    <input name="name" type="text" class="form-control" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Price</label>
                                    <input name="price" type="number" class="form-control" step="0.01" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Stock</label>
                                    <input name="stock" type="number" class="form-control" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Product Type</label>
                                    <select id="productType" name="productType" class="form-select" required>
                                        <c:forEach var="type" items="${listProductType}">
                                            <option value="${type.id}">${type.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="row mb-4">

        <div class="col">
            <form class="d-flex" role="search" action="${pageContext.request.contextPath}/product-list" method="get">
                <input class="form-control"
                       type="search"
                       placeholder="Search"
                       aria-label="Search"
                       name="search"
                       value="${param.search}" />
                <button type="submit" class="btn btn-primary ms-2">Search</button>
            </form>

        </div>
    </div>
    <div class="row mb-4">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Stock Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.stock}</td>
                        <td>${product.productType}</td>
                        <td>
                            <button onclick="updateProduct('${product.id}', '${product.name}', '${product.price}', '${product.stock}', '${product.typeId}')" type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editProductModal">Edit</button>
                            <button onclick="deleteProduct('${product.id}')" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteProductModal">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="editProductModal" tabindex="-1" aria-labelledby="editProduct" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title" id="addProductLabel">Add New Product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <form id="editProductForm" action="${pageContext.request.contextPath}/product-list" method="post">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" id="editProductIdModel">

                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label">Product's Name</label>
                        <input name="name" type="text" class="form-control" id="editProductNameModal" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Price</label>
                        <input name="price" type="number" class="form-control" step="0.01" id="editProductPriceModal" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Stock</label>
                        <input name="stock" type="number" class="form-control" id="editProductStockModal" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Product Type</label>
                        <select name="productType" class="form-select" id="editProductTypeModal" required>
                            <c:forEach var="type" items="${listProductType}">
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--<div class="modal fade" id="editProductModal" tabindex="-1" aria-labelledby="editProduct" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h1 class="modal-title fs-5" id="editProduct">Edit Product</h1>--%>
<%--                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <form id="editProductForm" action="/product-list" method="post">--%>
<%--                    <input type="hidden" name="action" value="edit">--%>
<%--                    <input type="hidden" name="id" id="editProductIdModel">--%>
<%--                    <table class="w-100">--%>
<%--                        <tr>--%>
<%--                            <td class="col-4">Product's Name</td>--%>
<%--                            <td class="col-8"><input name="name" type="text" class="form-control" id="editProductNameModal"></td>--%>
<%--                        </tr>--%>

<%--                        <tr>--%>
<%--                            <td>Price</td>--%>
<%--                            <td><input name="price" type="number" class="form-control" id="editProductPriceModal" step="0.01"></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Stock</td>--%>
<%--                            <td><input name="stock" type="number" class="form-control" id="editProductStockModal"></td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                        <button type="submit" class="btn btn-primary">Save changes</button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="modal fade" id="deleteProductModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="deleteProductForm" action="/product-list" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="productId" id="deleteProductId">
                    <span>Are you sure you want to delete this product?</span>
                    <span id="deletePreviewId"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="/boostrap/js/bootstrap.bundle.js"></script>
<script>
    function deleteProduct(id){
        document.getElementById("deleteProductId").value = id;
        document.getElementById("deletePreviewId").value = id;
    }

    function updateProduct(id, name, price, stock, typeId) {
        document.getElementById("editProductIdModel").value = id;
        document.getElementById("editProductNameModal").value = name;
        document.getElementById("editProductPriceModal").value = price;
        document.getElementById("editProductStockModal").value = stock;
        document.getElementById("editProductTypeModal").value = typeId;
    }


</script>
</html>
