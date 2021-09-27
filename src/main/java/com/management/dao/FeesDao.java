package com.management.dao;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.management.model.FeesStructure;
import com.management.model.Subjects;
import com.management.model.Teacher;
import com.management.model.TeacherMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository
public class FeesDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	SessionFactory sessionFactory;

	// @Autowired(required = true)
	// Session session;

	public List<TeacherMap> teacherMapSubject(int t_id, int s_id, Teacher teacher) {
		// TODO Auto-generated method stub

		String sql = "Teacher.t_id , Subject.s_id , Subject.subjectname FROM Teacher INNER JOIN Subjects ON Teacher.t_id = Subjects.t_id";
		System.out.println("Teacher MAP DAO...");
		Session currentSession = sessionFactory.getCurrentSession();
		// currentSession.saveOrUpdate(department);

		Query<Subjects> query = currentSession.createQuery(sql);
		query.setParameter(0, teacher.getDepartment());
		// query.setParameter(1, teacher.getYear());

		List<Subjects> list = query.getResultList();

		return null;
	}

	public List<FeesStructure> getFees() {
		// TODO Auto-generated method stub
		List<FeesStructure> loadAll = this.hibernateTemplate.loadAll(FeesStructure.class);
		return loadAll;
	}

	@Transactional
	public void addFees(FeesStructure feesStructure) {
		// TODO Auto-generated method stub

		if (feesStructure.getPaidAmount() == feesStructure.getTotalAmount()) {
			feesStructure.setStatus("Amount_Paid");
			// session.update(feesStructure);
			this.hibernateTemplate.saveOrUpdate(feesStructure);

			System.out.println("Status : " + feesStructure.getStatus());
		} else {
			feesStructure.setStatus("Un_paid");
			// session.update(feesStructure);

			this.hibernateTemplate.saveOrUpdate(feesStructure);

			System.out.println("Status : " + feesStructure.getStatus());

		}

	}

	public FeesStructure getFeesByID(int id) {
		// TODO Auto-generated method stub

		return this.hibernateTemplate.get(FeesStructure.class, id);
	}

	@Transactional
	public void UpdateFeesStructure(FeesStructure feesStructure) {
		// TODO Auto-generated method stub
		System.out.println("DAO started");
		this.hibernateTemplate.saveOrUpdate(feesStructure);
		System.out.println("DAO Finished");

		// if(feesStructure.getPaidAmount() != feesStructure.getTotalAmount()) {
		// String s = "Amount Paid";
		// feesStructure.setStatus(s);
		//
		// System.out.println("amount : "+ feesStructure.getStatus());
		// }
	}

	@Transactional
	public void deleteFees(int id) {
		// TODO Auto-generated method stub
		FeesStructure load = this.hibernateTemplate.load(FeesStructure.class, id);

		if (load.getStatus().equals("Un_paid")) {
			System.out.println("cant detele Sorry....");

		} else {
			this.hibernateTemplate.delete(load);
		}
	}

	public List<FeesStructure> DownloadPDF() {
		// TODO Auto-generated method stub

		List<FeesStructure> list = this.hibernateTemplate.loadAll(FeesStructure.class);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

		try {
			Map<String,Object> parameters = new HashMap<String, Object>();
			parameters.put("studentName", "Nimish");
			
			String filePath = "C:\\Nimish\\PROJECT\\StudentManagement\\src\\main\\resources\\SecondReport.jrxml";

			// We need to Compile the report & for that we have
			// "JasperCompileManager"
			JasperReport Report = JasperCompileManager.compileReport(filePath);
			
			
			// Now we need to fill the data to Jasper report
			JasperPrint print = JasperFillManager.fillReport(Report,parameters ,dataSource);

			// now exporting this report to pdf
			String pathToStore = "C:\\Users\\nimish.khedkar\\Documents\\export-pdfs";
			JasperExportManager.exportReportToPdfFile(print, pathToStore + "\\fees.pdf");

			System.out.println("Report created...!");

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// -------------------------------
	// -------------------------------
	// -------------------------------

}
