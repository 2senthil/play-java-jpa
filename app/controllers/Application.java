package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Bar;
import models.Card;
import models.Skill;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static play.libs.Json.toJson;

public class Application extends Controller {
    
    public static Result index() {
        return ok(index.render(Form.form(Bar.class)));
    }

    @Transactional
    public static Result addBar() {
        Form<Bar> form = Form.form(Bar.class).bindFromRequest();
        Bar bar = form.get();
        JPA.em().persist(bar);
        return redirect(controllers.routes.Application.index());
    }

    @Transactional(readOnly = true)
    public static Result listBars() {
        CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
        CriteriaQuery<Bar> cq = cb.createQuery(Bar.class);
        Root<Bar> root = cq.from(Bar.class);
        CriteriaQuery<Bar> all = cq.select(root);
        TypedQuery<Bar> allQuery = JPA.em().createQuery(all);
        JsonNode jsonNodes = toJson(allQuery.getResultList());
        return ok(jsonNodes);
    }

    @Transactional(readOnly = true)
    public static Result listSkills() {
        CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
        CriteriaQuery<Skill> cq = cb.createQuery(Skill.class);
        Root<Skill> root = cq.from(Skill.class);
        CriteriaQuery<Skill> all = cq.select(root);
        TypedQuery<Skill> allQuery = JPA.em().createQuery(all);
        JsonNode jsonNodes = toJson(allQuery.getResultList());
        return ok(jsonNodes);
    }

    @Transactional(readOnly = true)
    public static Result getSkill(Long id) {
        TypedQuery<Skill> query = JPA.em().createQuery(
                "SELECT c FROM Skill c WHERE c.id = :id", Skill.class);
        return ok(toJson(query.setParameter("id", id).getSingleResult()));
    }

    @Transactional(readOnly = true)
    public static Result listCards() {
        CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
        CriteriaQuery<Card> cq = cb.createQuery(Card.class);
        Root<Card> root = cq.from(Card.class);
        CriteriaQuery<Card> all = cq.select(root);
        TypedQuery<Card> allQuery = JPA.em().createQuery(all);
        JsonNode jsonNodes = toJson(allQuery.getResultList());
        return ok(jsonNodes);
    }
    
}
