@GetMapping(value="/story")
	public String getLatestStory()
	{
		String url="https://time.com/";
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.getForObject(url, String.class);
		try {
			Document doc = Jsoup.parse(response);
			Element p= doc.select("p").first();
//			String text = doc.body().text(); //some bold text
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Latest News", doc);
			//Converting JSON Object using toString() method
			String myJSONString = jsonObject.toString();
			String str = myJSONString;
			str = str.replaceAll("[<p>]", "");
			
			
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return null;
		
	}

	________________________________________________________________
	curl --location 'http://localhost:55004/story'

	Output:
	{"Latest News":" class=\"summary\" At least 99 eole have died, making it the deadliest wildfire in the U.S. in over a century. \/"}
	
	
	
	
	