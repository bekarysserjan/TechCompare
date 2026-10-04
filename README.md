# TechCompare v14

## Frontend
- Added a Price tab directly inside Hardware comparison.
- Price comparison uses the selected devices' `price` / `priceUsd` data.
- Keeps the characteristics carousel and existing quick/custom comparison behavior.
- Fixed `quickSelected` prop passing in Ranking from v13.

## Backend AI fix
The previous GeminiService used `gemini-2.0-flash`, which was shut down by Google on June 1, 2026.
The patch changes the model to `gemini-3.6-flash`.

Copy the three files from `backend-patch/service/` into your backend's corresponding `service/` folder, replacing the existing files:
- GeminiService.java
- AiRecommendationService.java
- ScoringService.java

Then in the SAME PowerShell terminal used to start the backend:

```powershell
cd "C:\Users\Admin\Desktop\laba\backend"
$env:GEMINI_API_KEY="YOUR_GEMINI_API_KEY"
.\gradlew.bat bootRun
```

Frontend:

```powershell
cd "C:\Users\Admin\Desktop\laba\frontend\techcompare-v10\frontend"
npm install
npm run dev
```

If AI still returns HTTP 500 after this model change, copy the backend stack trace starting at `Caused by:`.
