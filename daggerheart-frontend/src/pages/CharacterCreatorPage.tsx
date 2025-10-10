import React, { useState } from "react";
import { ClassSelection } from "../components/ClassSelection";
import { SubclassSelection } from "../components/SubclassSelection";
import { AncestrySelection } from "../components/AncestrySelection";
import { CommunitySelection } from "../components/CommunitySelection";
import { StatDistribution } from "../components/StatDistribution";

function CharacterCreatorPage() {
  const [currentStep, setCurrentStep] = useState(1);

  const nextStep = () => setCurrentStep((prev) => prev + 1);
  const prevStep = () => setCurrentStep((prev) => prev - 1);

  // A simple function to render the correct component based on the current step
  const renderStep = () => {
    switch (currentStep) {
      case 1:
        return <ClassSelection onNext={nextStep} />;
      case 2:
        return <SubclassSelection onNext={nextStep} onBack={prevStep} />;
      case 3:
        return <AncestrySelection onNext={nextStep} onBack={prevStep} />;
      case 4:
        return <CommunitySelection onNext={nextStep} onBack={prevStep} />;
      case 5:
        return <StatDistribution onNext={nextStep} onBack={prevStep} />;
      default:
        return <ClassSelection onNext={nextStep} />;
    }
  };

  return (
    <div>
      <h1>Character Creation (Step {currentStep})</h1>
      {renderStep()};
      {/* The different steps of the creator will be rendered here */}
    </div>
  );
}

export default CharacterCreatorPage;
