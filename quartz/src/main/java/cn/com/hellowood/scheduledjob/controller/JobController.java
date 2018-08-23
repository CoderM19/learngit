package cn.com.hellowood.scheduledjob.controller;

import cn.com.hellowood.scheduledjob.common.CommonResponse;
import cn.com.hellowood.scheduledjob.common.ResponseUtil;
import cn.com.hellowood.scheduledjob.model.PageHelperEntity;
import cn.com.hellowood.scheduledjob.model.ScheduleJob;
import cn.com.hellowood.scheduledjob.service.JobService;
import cn.com.hellowood.scheduledjob.utils.ServiceException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;
    
    @PostMapping(value="/all")
	public Map<String, Object> queryjob(@RequestBody PageHelperEntity pageHelperEntity) {
    	int pageNum = pageHelperEntity.getPageNum();
    	int pageSize = pageHelperEntity.getPageSize();
		PageInfo<ScheduleJob> ScheduleJob = jobService.getALLJob(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ScheduleJob", ScheduleJob);
		map.put("number", ScheduleJob.getTotal());
		return map;
	}
    
    
    
    @GetMapping
    public CommonResponse getAllJob() {
        return ResponseUtil.generateResponse(jobService.getAllJob());
    }

    @GetMapping("/{id}")
    public CommonResponse getJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.select(jobId));
    }

    @PutMapping("/update/{id}")
    public CommonResponse updateJob(@PathVariable("id") Long jobId, @RequestBody ScheduleJob newScheduleJob) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.update(jobId, newScheduleJob));
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.delete(jobId));
    }

    @PostMapping("/save")
    public CommonResponse saveJob(@RequestBody(required=false) ScheduleJob newScheduleJob) throws ServiceException {
       
    	return ResponseUtil.generateResponse(jobService.add(newScheduleJob));
    }


    @GetMapping("/run/{id}")
    public CommonResponse runJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.run(jobId));
    }


    @GetMapping("/pause/{id}")
    public CommonResponse pauseJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.pause(jobId));
    }

    @GetMapping("/resume/{id}")
    public CommonResponse resumeJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.resume(jobId));
    }

}
