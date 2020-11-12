package come.codegym.controller;

import come.codegym.model.Category;
import come.codegym.model.Product;
import come.codegym.service.CategoryService;
import come.codegym.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/home")
public class Servlet extends HttpServlet {
        private ProductService productService;
        private CategoryService categoryService;

        public void init() {
            productService = new ProductService();
            categoryService = new CategoryService();
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insert(req, resp);
                    break;
                case "edit":
                    update(req, resp);
                    break;
                case "search":
                    searchByName(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                default:
                    list(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name1 = req.getParameter("name");
        String name = "%"+name1+"%";
        List<Product> list = productService.findByName(name);
        req.setAttribute("list",list);
        List<Category> listCategory = categoryService.findAll();
        req.setAttribute("listCategory",listCategory);
        RequestDispatcher rd = req.getRequestDispatcher("views/list.jsp");
        rd.forward(req, resp);
    }



    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = productService.findAll();
        req.setAttribute("list",list);
        List<Category> listCategory = categoryService.findAll();
        req.setAttribute("listCategory",listCategory);
        RequestDispatcher rd = req.getRequestDispatcher("views/list.jsp");
        rd.forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            productService.delete(id);
            List<Product> list = productService.findAll();
            List<Category> listCategory = categoryService.findAll();
            req.setAttribute("listCategory",listCategory);
            req.setAttribute("list", list);
            req.setAttribute("listCategory",listCategory);
            RequestDispatcher rd = req.getRequestDispatcher("views/list.jsp");
            rd.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            Product product = productService.findOne(id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/edit.jsp");
            req.setAttribute("product", product);
            dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/create.jsp");
        dispatcher.forward(req, resp);
    }


    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            String productName = req.getParameter("productName");
            Long categoryId = Long.valueOf(req.getParameter("categoryId"));
            Long price = Long.valueOf(req.getParameter("price"));
            Long quantity = Long.valueOf(req.getParameter("quantity"));
            String color = req.getParameter("color");
            Product  product = new Product(id, productName, categoryId, price, quantity, color);
            List<Category> listCategory = categoryService.findAll();
            req.setAttribute("listCategory",listCategory);
            productService.update(product);
            req.setAttribute("list",productService.findAll());
            RequestDispatcher rd = req.getRequestDispatcher("views/list.jsp");
            rd.forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String productName = req.getParameter("productName");
            Long categoryId = Long.valueOf(req.getParameter("categoryId"));
            Long price = Long.valueOf(req.getParameter("price"));
            Long quantity = Long.valueOf(req.getParameter("quantity"));
            String color = req.getParameter("color");
            List<Category> listCategory = categoryService.findAll();
            req.setAttribute("listCategory",listCategory);
            Product product = new Product(productName, categoryId, price, quantity, color);
            productService.save(product);
            req.setAttribute("list",productService.findAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
            dispatcher.forward(req, resp);
    }



}
