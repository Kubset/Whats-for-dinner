package servlets;

import Criteria.AllComponents;
import Criteria.AllUnits;
import Criteria.SqlCriteria;
import DAO.ComponentDAO;
import DAO.UnitDAO;
import Mappers.ComponentMapper;
import Mappers.Mapper;
import Mappers.UnitMapper;
import Model.Component;
import Model.Unit;
import com.google.gson.Gson;
import services.UnitManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ApiUnitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] URL = req.getRequestURI().toString().split("/");
        String json;
        UnitManager unitManager = new UnitManager();
        Mapper<Unit> mapper = new UnitMapper();

        if(URL.length == 4 && URL[3].matches("\\d+")) {
            Unit unit = unitManager.get(Integer.parseInt(URL[3]));
            json = mapper.mapToJson(unit);
        } else {
            List<Unit> units = unitManager.getAll();
            json = mapper.mapToJson(units);
        }

        if(!json.equals("null")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

